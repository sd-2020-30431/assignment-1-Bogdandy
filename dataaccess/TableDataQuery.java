package dataaccess;

import business.UserDataStructure;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import org.hibernate.*;
import org.hibernate.criterion.Expression;

public class TableDataQuery {
    private UserDataStructure data;
    
    public TableDataQuery(UserDataStructure data){
        this.data = data;
    }
    
    public TableModel  doQuery(){
        DefaultTableModel tblModel = new DefaultTableModel();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(GroceryItem.class);
            criteria.add(Expression.eq("ListNo", 1));
            
            List groceryList = criteria.list();
            
            for (Iterator iterator = groceryList.iterator(); iterator.hasNext();){
                GroceryItem gc = (GroceryItem) iterator.next(); 
                tblModel.addRow(new Object[]{
                    gc.getItemName(),
                    gc.getQuantity(),
                    gc.getCaloricValue(),
                    gc.getPurchaseDate(),
                    gc.getExpirationDate(),
                    gc.getConsumptionDate()});
            }
            tx.commit();
            return tblModel;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(null, "Couldn't populate table!\nCheck connection to the server.", "Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            session.close();
        }
        return tblModel;
    }
}

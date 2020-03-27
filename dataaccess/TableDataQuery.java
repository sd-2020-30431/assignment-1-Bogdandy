package dataaccess;

import business.UserDataStructure;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import org.hibernate.*;

public class TableDataQuery {
    private UserDataStructure data;
    
    public TableDataQuery(UserDataStructure data){
        this.data = data;
    }
    
    public TableModel  doQuery(){
        DefaultTableModel tblModel = new DefaultTableModel();
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
           List<GroceryItem> groceryList = session.createQuery(
                   "select gc " +
                           "from GroceryItem gc " +
                           "where gc.User.id = :idGroceryItem", GroceryItem.class)
                   .setParameter( "idGroceryItem", 1L )
                   .getResultList();
           
           for (GroceryItem gc: groceryList){
                tblModel.addRow(new Object[]{
                    gc.getItemName(),
                    gc.getQuantity(),
                    gc.getCaloricValue(),
                    gc.getPurchaseDate(),
                    gc.getExpirationDate(),
                    gc.getConsumptionDate()});
            }
            return tblModel;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Couldn't populate table!\nCheck connection to the server.", "Warning", JOptionPane.WARNING_MESSAGE);
        } finally {
            session.close();
        }
        return tblModel;
    }
}

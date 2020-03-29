package dataaccess;

import business.*;
import org.hibernate.*;
import org.hibernate.criterion.Expression;

public class SearchItemQuery {
    private Session session;
    private GroceryItem gc;
    private final UserDataStructure uSD;
    private final ItemInformation itemInformation;
    
    public SearchItemQuery(ItemInformation itemInformation, UserDataStructure uSD){
        this.uSD = uSD;
        this.itemInformation = itemInformation;
    }
    public boolean doQuery(){
        Query query = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
         
            Criteria criteria = session.createCriteria(GroceryItem.class);
            criteria.add(Expression.eq("ItemName", itemInformation.getItemName()));
            criteria.add(Expression.eq("ListNo", itemInformation.getTableIndex()));
            criteria.add(Expression.eq("idUserGroceryList", uSD.getIdUser()));
                    
            gc =(GroceryItem) criteria.uniqueResult();
            tx.commit();
            
            
            return gc != null;
        } catch(HibernateException | NullPointerException e) {
            if (tx!=null) tx.rollback();
            session.close(); 
            //e.printStackTrace(); 
            return false;
        }
    }
}

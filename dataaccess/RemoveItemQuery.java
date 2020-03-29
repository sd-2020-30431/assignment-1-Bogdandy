package dataaccess;

import business.ItemInformation;
import business.UserDataStructure;
import org.hibernate.*;

public class RemoveItemQuery {
    private ItemInformation itemInformation;
    private UserDataStructure uSD;
    private Session session;
    
    public RemoveItemQuery(ItemInformation itemInformation, UserDataStructure uSD){
        this.itemInformation = itemInformation;
        this.uSD = uSD;
    }
    
    public boolean doQuery(){
        Query query = null;
        Transaction tx = null;
        session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            tx = session.beginTransaction();
            
            query = session.createQuery("delete from GroceryItem where idGroceryList=:idGroceryList");
            query.setParameter("idGroceryList", itemInformation.getItemId());
            
            int l = query.executeUpdate();
            tx.commit();
            
            if(l > 0){
                return true;
            }
            else{
                return false;
            }
        } catch(HibernateException | NullPointerException e) {
            session.close();
            //e.printStackTrace(); 
            return false;
        }finally{
            session.close();
        }
    }
}

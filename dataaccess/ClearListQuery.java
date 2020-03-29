package dataaccess;

import business.*;
import org.hibernate.*;

public class ClearListQuery {
    private ItemInformation itemInformation;
    private UserDataStructure uSD;
    private Session session;
    
    public ClearListQuery(ItemInformation itemInformation, UserDataStructure uSD){
        this.itemInformation = itemInformation;
        this.uSD = uSD;
    }
    
    public boolean doQuery(){
        Query query = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
            query = session.createQuery("delete from GroceryItem where ListNo = :ListNo and idUserGroceryList=:idUserGroceryList");
            query.setParameter("idUserGroceryList", uSD.getIdUser());
            query.setParameter("ListNo", itemInformation.getTableIndex());
            
            int l = query.executeUpdate();
            tx.commit();
            
            if(l > 0){
                return true;
            }
            else{
                return false;
            }
        } catch(HibernateException | NullPointerException e) {
            //e.printStackTrace(); 
            return false;
        }finally{
            session.close();
        }
    }
}

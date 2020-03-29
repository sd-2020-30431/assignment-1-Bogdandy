package dataaccess;

import business.*;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemInformationModificationQuery {
    private ItemInformation itemInformation;
    private UserDataStructure uSD;
    
    public ItemInformationModificationQuery(ItemInformation itemInformation, UserDataStructure uSD){
        this.itemInformation = itemInformation;
        this.uSD = uSD;
    }
    
    public boolean doQuery(){
        boolean successful = false;
        GroceryItem groceryItem = new GroceryItem();
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            
            groceryItem.setIdGroceryList(itemInformation.getItemId());
            groceryItem.setListNo(itemInformation.getTableIndex());
            groceryItem.setIdUserGroceryList(uSD.getIdUser());
            groceryItem.setItemName(itemInformation.getItemName());
            groceryItem.setQuantity(itemInformation.getQuantity());
            groceryItem.setCaloricValue(itemInformation.getCaloricValue());
            groceryItem.setPurchaseDate(itemInformation.getPurchaseDate());
            groceryItem.setExpirationDate(itemInformation.getExpirationDate());
            groceryItem.setConsumptionDate(itemInformation.getConsumptionDate());
            session.update(groceryItem);
            
            successful = true;            
            tx.commit();
        } catch (HibernateException e) {          
            session.close();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Couldn't populate table!\nCheck connection to the server.", "Warning", JOptionPane.WARNING_MESSAGE);
            return successful;
        } finally {
            session.close();
        }
        return successful;
    }
}

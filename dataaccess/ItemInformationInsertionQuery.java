package dataaccess;

import javax.persistence.*;
import org.hibernate.HibernateException;
import business.ItemInformation;

public class ItemInformationInsertionQuery {
    private ItemInformation data;
    
    public ItemInformationInsertionQuery(ItemInformation data){
        this.data = data;
    }
    
    public boolean doQuery(){
        boolean successful = false;
        GroceryItem groceryItem = new GroceryItem();
       
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
       
        groceryItem.setTableIndex(data.getTableIndex());
        groceryItem.setItemName(data.getItemName());
        groceryItem.setQuantity(data.getQuantity());
        groceryItem.setCaloricValue(data.getCaloricValue());
        groceryItem.setPurchaseDate(data.getPurchaseDate());
        groceryItem.setExpirationDate(data.getExpirationDate());
        groceryItem.setConsumptionDate(data.getConsumptionDate());
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        entityManager.persist(groceryItem);
       
        try{
            entityManager.getTransaction().commit();
            successful = true;
        }catch(HibernateException ex){
           
        }finally{
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
        return successful;
        
    }
}

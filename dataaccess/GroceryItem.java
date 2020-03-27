package dataaccess;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="grocerylist")
public class GroceryItem{
    @Id
    @Column (name = "idGroceryList")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int idGroceryList;
     public Integer getIdGroceryList(){
        return idGroceryList;
    }
    
    public void setIdGroceryList(int idGroceryList){
        this.idGroceryList = idGroceryList;
    }
    
    @Column(name = "ItemName")
    private String ItemName;
    public String getItemName(){
        return ItemName;
    }
    
    public void setItemName(String ItemName){
        this.ItemName = ItemName;
    }
    
    @Column (name = "ListNo")
    private Integer tableIndex;
    public Integer getTableIndex(){
        return tableIndex;
    }
    
    public void setTableIndex(int tableIndex){
        this.tableIndex = tableIndex;
    }
    
    @Column(name = "Quantity")
    private int quantity;
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    @Column(name = "CaloricValue")
    private Integer caloricValue;
    public Integer getCaloricValue(){
        return caloricValue;
    }
    
    public void setCaloricValue(int caloricValue){
        this.caloricValue = caloricValue;
    }
    
    
    @Column(name = "PurchaseDate")
    private Date purchaseDate;
    public Date getPurchaseDate(){
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    
    @Column(name = "ExpirationDate")
    private Date expirationDate;
    public Date getExpirationDate(){
        return expirationDate;
    }
    
    public void setExpirationDate(Date expirationDate){
        this.expirationDate = expirationDate;
    }
    
    @Column(name = "ConsumptionDate")
    private Date consumptionDate;
    public Date getConsumptionDate(){
        return consumptionDate;
    }
    
    public void setConsumptionDate(Date consumptionDate){
        this.consumptionDate = consumptionDate;
    }
}

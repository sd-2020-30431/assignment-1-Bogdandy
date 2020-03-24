package business;

import java.util.Date;

public class ItemInformation<T>{
    private String itemName;
    private Integer quantity;
    private Integer caloricValue;
    private Date purchaseDate;
    private Date expirationDate;
    private Date consumptionDate;
    private Integer tableIndex;
    
    public ItemInformation(String itemName, Integer quantity, Integer caloricValue, Date purchaseDate, Date expirationDate, Date consumptionDate, Integer tableIndex){
        this.itemName = itemName;
        this.quantity = quantity;
        this.caloricValue = caloricValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
        this.tableIndex = tableIndex;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    
    public Integer getCaloricValue(){
        return caloricValue;
    }
    
    public Date getPurchaseDate(){
        return purchaseDate;
    }
    
    public Date getExpirationDate(){
        return expirationDate;
    }
    
    public Date getConsumptionDate(){
        return consumptionDate;
    }
    
    public Integer getTableIndex(){
        return tableIndex;
    }
}

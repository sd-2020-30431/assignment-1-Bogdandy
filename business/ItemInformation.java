package business;

import java.util.Date;

public class ItemInformation<T>{
    private String itemName;
    private Integer quantity;
    private Integer caloricValue;
    private Date purchaseDate;
    private Date expirationDate;
    private Date consumptionDate;
    
    public ItemInformation(String itemName, Integer quantity, Integer caloricValue, Date purchaseDate, Date expirationDate, Date consumptionDate){
        this.itemName = itemName;
        this.quantity = quantity;
        this.caloricValue = caloricValue;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
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
}

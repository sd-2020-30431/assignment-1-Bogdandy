package business;

public class ReportDataStructure {
    private String itemName;
    private int tableIndex;
    private int quantity;
    private int weekOfYear;
    private int year;
    private int calories;
    
    public ReportDataStructure(String itemName, int tableIndex, int quantity, int calories, int weekOfYear, int year){
        this.itemName = itemName;
        this.quantity = quantity;
        this.tableIndex = tableIndex;
        this.weekOfYear = weekOfYear;
        this.year = year;
        this.calories = calories;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    
    public void setWeekOfYear(int weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getItemName() {
        return itemName;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public int getCalories() {
        return calories;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeekOfYear() {
        return weekOfYear;
    }

    public int getYear() {
        return year;
    }
        
}

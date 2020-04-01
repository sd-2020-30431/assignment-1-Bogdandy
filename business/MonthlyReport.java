package business;

import dataaccess.GroceryItem;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MonthlyReport {
    List<GroceryItem> groceyListl;
        
    public MonthlyReport createReport(){
        //groceryList.get(0).getPurchaseDate();
        File myObj = new File(System.getProperty("user.home") + "\\Desktop\\", "Monthly Report "+"31-3-2020"+".txt");
        try{
            if(myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }else {
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            return null;
        }
        return null;
    }
}

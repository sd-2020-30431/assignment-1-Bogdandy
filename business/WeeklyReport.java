package business;

import dataaccess.GroceryItem;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WeeklyReport {
    List<GroceryItem> groceryList;
    
    public WeeklyReport createReport(){
      //groceryList.get(0).getPurchaseDate();
      for(GroceryItem groceryItem: groceryList){
          
      }
      
      File myObj = new File(System.getProperty("user.home") + "\\Desktop\\", "Weekly Report "+"31-3-2020"+".txt");
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

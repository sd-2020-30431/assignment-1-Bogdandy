package business;

import dataaccess.GroceryItem;
import java.io.*;
import java.text.*;
import java.util.*;

public class MonthlyReport {
    private List<GroceryItem> groceryList;
    private int calories;
        
    public MonthlyReport createReport(List groceryItems){
        groceryList = groceryItems;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        Date date = new Date();
        
        String Path = System.getProperty("user.home") + "\\Desktop\\" + "Monthly Report " + dateFormat.format(date) + ".txt";
        File file = new File(Path);
        
        try{
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter myWriter = new FileWriter(Path);
                myWriter.write("Report ");
                
                for(int i = 1; i <= 5; i ++){
                    calories = 0;
                    myWriter.write("\n\nGroceryList " + i + ":");
                    for (GroceryItem groceryItem: groceryList){
                        if(groceryItem.getListNo() == i){
                            myWriter.write("\n" + groceryItem.getItemName() + " " + groceryItem.getCaloricValue() + " " + groceryItem.getQuantity());
                            calories += groceryItem.getCaloricValue();
                        }
                    } 
                    myWriter.write("\nTotal Calories: "+ calories);
                }
               
                
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }else {
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            return null;
        }
        return null;
    }
}

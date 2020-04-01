package business;

import dataaccess.GroceryItem;
import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.IsoFields;
import java.util.*;

public class WeeklyReport {
    private List<GroceryItem> groceryList;
    private List<Date> checkDates;
    private List<ReportDataStructure> reportItems = new ArrayList<>();
    
    public WeeklyReport createReport(List groceryItems){
        groceryList = groceryItems;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	Date date = new Date();
        
        String Path = System.getProperty("user.home") + "\\Desktop\\" + "Weekly Report "+dateFormat.format(date)+".txt";
        File file = new File(Path);
        
        try{
            if(file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter myWriter = new FileWriter(Path);
                myWriter.write("Report ");
                
                for (GroceryItem groceryItem: groceryList){
                    boolean check = true;
                    int year = -1;
                    int week = -1;
                    int i = 0;
                    int j = 0;
                    checkDates = new ParseDates().parseDates(groceryItem.getPurchaseDate(), groceryItem.getConsumptionDate());
                    for(Date intermediaryDate : checkDates){
                        LocalDate ld = intermediaryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int weekDate = ld.get( IsoFields.WEEK_OF_WEEK_BASED_YEAR ) ;
                        int yearDate = ld.get( IsoFields.WEEK_BASED_YEAR ) ;
                        
                        if(check){
                            year = yearDate;
                            week = weekDate;
                            check = false;
                        }
                        
                        Calendar calendar = new GregorianCalendar();

                        if(year == yearDate){
                            if(week == weekDate){
                                i++;
                            }else if(year!=-1){
                                i++;
                                int calories = (groceryItem.getCaloricValue()*groceryItem.getQuantity())/i;
                                reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getListNo(), groceryItem.getQuantity(), calories, week, year));
                                i = 0;
                                week = weekDate;
                                year = yearDate;
                            }
                        }
                    } 
                }
                
                Collections.sort(reportItems, (Object o1, Object o2) -> {
                    Integer x1 = ((ReportDataStructure) o1).getWeekOfYear();
                    Integer x2 = ((ReportDataStructure) o2).getWeekOfYear();
                    Integer sComp = x1.compareTo(x2);

                    if (sComp != 0) {
                        return sComp;
                    }
                    
                    Integer x3 = ((ReportDataStructure) o1).getYear();
                    Integer x4 = ((ReportDataStructure) o2).getYear();
                    return x3.compareTo(x4);
                });
                
                for(int i = 1; i <= 5; i ++){
                    myWriter.write("\n\nGroceryList " + i + ":");
                    boolean pass = true;
                    int year = 0;
                    int week = 0;
                    int calories = 0;
                    for (ReportDataStructure reportItem: reportItems){
                        if(reportItem.getTableIndex() == i){
                            calories += reportItem.getCalories();
                            myWriter.write("\n" + reportItem.getItemName() + " " + reportItem.getQuantity() +
                                    " " + reportItem.getCalories() + " " + reportItem.getWeekOfYear() + " " +
                                    reportItem.getYear());
                        }
                    } myWriter.write("\nTotal Calories: " + calories);
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

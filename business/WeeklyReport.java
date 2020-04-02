package business;

import dataaccess.GroceryItem;
import java.io.*;
import java.text.*;
import java.util.*;

public class WeeklyReport {
    private List<GroceryItem> groceryList;
    private List<Date> checkDates;
    private final List<ReportDataStructure> reportItems = new ArrayList<>();
    
    public WeeklyReport createReport(List groceryItems){
        groceryList = groceryItems;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date date = new Date();
        
        String Path = System.getProperty("user.home") + "\\Desktop\\" + "Weekly Report "+dateFormat.format(date)+".txt";
        File file = new File(Path);
        
        try{
            if(file.createNewFile()) {
                FileWriter myWriter = new FileWriter(Path);
                myWriter.write("Report ");
                
                for (GroceryItem groceryItem: groceryList){
                    boolean check = true;
                    boolean check2 = true;
                    int week = -1;
                    int year = -1;
                    int intermediate = 0;
                    checkDates = new ParseDates().parseDates(groceryItem.getPurchaseDate(), groceryItem.getConsumptionDate());
                    int days = checkDates.size();
                    for (Iterator<Date> it = checkDates.iterator(); it.hasNext();){
                        Date intermediaryDate = it.next();
                        Calendar cal1 = Calendar.getInstance();
                        cal1.setTime(intermediaryDate);
                        int yearDate = cal1.get(Calendar.YEAR);
                        int weekDate = cal1.get(Calendar.WEEK_OF_YEAR);
                        
                        if(check){
                            year = yearDate;
                            week = weekDate;
                            check = false;
                        }

                        if(year == yearDate){
                            if(week != weekDate){
                                if(check2){
                                    intermediate = checkDates.indexOf(intermediaryDate);
                                    check2 = false;
                                }else{
                                    intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                                }
                                
                                int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity()) * intermediate)/days ;
                                reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getListNo(), groceryItem.getQuantity(), calories, week, year));
                                week = weekDate;
                                year = yearDate;
                            }else{
                                if(!it.hasNext()){
                                    intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                                    int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity() * intermediate)/days);
                                    reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getListNo(), groceryItem.getQuantity(), calories, week, year));
                                }
                            }
                        }else if(year!=-1){
                                intermediate = checkDates.indexOf(intermediaryDate) - intermediate + 1;
                                int calories = ((groceryItem.getCaloricValue() * groceryItem.getQuantity()) * intermediate)/days ;
                                reportItems.add(new ReportDataStructure(groceryItem.getItemName(), groceryItem.getListNo(), groceryItem.getQuantity(), calories, week, year));
                                week = weekDate;
                                year = yearDate;
                        }
                    } 
                }
                
                Collections.sort(reportItems, (Object o1, Object o2) -> {
                    Integer x1 = ((ReportDataStructure) o1).getCriteria();
                    Integer x2 = ((ReportDataStructure) o2).getCriteria();
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
                    boolean check = true;
                    int yearDate = -1;
                    int weekDate = -1;
                    int calories = 0;
                    for (Iterator<ReportDataStructure> it = reportItems.iterator(); it.hasNext();){
                        ReportDataStructure reportItem = it.next();
                        if(reportItem.getTableIndex() == i){
                            if(check){
                                yearDate = reportItem.getYear();
                                weekDate = reportItem.getCriteria();
                                check = false;
                                myWriter.write("\nWeek " + weekDate + " Year " + yearDate);
                            }
                            
                            if(yearDate == reportItem.getYear()){
                                if(weekDate == reportItem.getCriteria()){
                                    calories += reportItem.getCalories();
                                    myWriter.write("\n" + reportItem.getItemName() + " " + reportItem.getQuantity() + " " + reportItem.getCalories());
                                }else{
                                    myWriter.write("\nTotal Calories: " + calories + "\n");

                                    calories = reportItem.getCalories();
                                    yearDate = reportItem.getYear();
                                    weekDate = reportItem.getCriteria();

                                    myWriter.write("\nWeek " + weekDate + " Year " + yearDate);
                                    myWriter.write("\n" + reportItem.getItemName() + " " + reportItem.getQuantity() + " " + reportItem.getCalories());
                                }
                                if(!it.hasNext()){
                                    myWriter.write("\nTotal Calories: " + calories + "\n");
                                }
                            }
                        }
                    } 
                }
                
               
                
                myWriter.close();
                // System.out.println("Successfully wrote to the file.");
            }else {
                //System.out.println("File already exists.");
            }
        }catch(IOException e){
            return null;
        }
        return null;
    }
}

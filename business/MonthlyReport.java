package business;

import java.io.File;
import java.util.ArrayList;


public class MonthlyReport implements Report{
    private ArrayList<ItemInformation> itemList;
    
    public MonthlyReport(ArrayList<ItemInformation> itemList){
        this.itemList = itemList;
    }

    @Override
    public File getFile() {
        return new File("");
    }
}

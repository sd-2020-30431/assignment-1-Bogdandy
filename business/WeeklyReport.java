package business;

import java.io.File;
import java.util.ArrayList;

public class WeeklyReport implements Report{
    private ArrayList<ItemInformation> itemList;
    
    public WeeklyReport(ArrayList<ItemInformation> itemList){
        this.itemList = itemList;
    }

    @Override
    public File getFile() {
        return new File("");
    }
}

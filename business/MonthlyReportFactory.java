package business;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MonthlyReportFactory implements AbstractFactory<MonthlyReport>{
    private ArrayList<ItemInformation> itemList;

    @Override
    public MonthlyReport create(String type, UserDataStructure uSD, int groceryListIndex) {
        JOptionPane.showMessageDialog(null,"Monthly Report is Being Made!");
        return null;
    }
}

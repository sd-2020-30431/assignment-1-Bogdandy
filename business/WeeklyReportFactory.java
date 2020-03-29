package business;

import javax.swing.JOptionPane;


public class WeeklyReportFactory implements AbstractFactory<WeeklyReport>{

    @Override
    public WeeklyReport create(String type, UserDataStructure uSD, int groceryListIndex) {
        JOptionPane.showMessageDialog(null,"Weekly Report is Being Made!");
        return null;
    }

}

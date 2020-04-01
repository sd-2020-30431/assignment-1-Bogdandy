package business;

import dataaccess.GroceryItem;
import java.util.List;

public class MonthlyReportFactory implements AbstractFactory<MonthlyReport>{

    @Override
    public MonthlyReport create(String type, List<GroceryItem> groceyList) {
        return new MonthlyReport().createReport();
    }
}

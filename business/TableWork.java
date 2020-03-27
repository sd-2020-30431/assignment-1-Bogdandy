package business;

import dataaccess.TableDataQuery;
import javax.swing.table.TableModel;

public class TableWork {
    private TableDataQuery tableDataQuery = null;
    private UserDataStructure data;
    
    public TableWork(UserDataStructure data){
        this.data = data;
    }
    
    public TableModel populateRequest(){
        tableDataQuery = new TableDataQuery(data);
        return tableDataQuery.doQuery();
    }
}

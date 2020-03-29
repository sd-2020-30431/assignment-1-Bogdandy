package business;

import dataaccess.TableDataQuery;
import javax.swing.table.TableModel;

public class PopulateTable{
    private TableDataQuery tableDataQuery = null;
    private UserDataStructure data;
    private int groceryListId;
    
    public PopulateTable(UserDataStructure data, int groceryListId){
        this.data = data;
        this. groceryListId = groceryListId;
    }
    
    public TableModel populateRequest(){
        tableDataQuery = new TableDataQuery(data, groceryListId);
        return tableDataQuery.doQuery();
    }
}

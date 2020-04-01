package business;

import dataaccess.RetrieveGroceryListQuery;
import java.util.List;

public class RetrieveGroceryList{

    public List requestModification(UserDataStructure uSD) {
        return new RetrieveGroceryListQuery(uSD).doQuery();
    }
    
}

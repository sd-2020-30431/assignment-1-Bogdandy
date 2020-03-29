package business;

import dataaccess.ClearListQuery;

public class ClearListRequest implements GroceryListRequestService {
    
    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        return new ClearListQuery(itemInformation, uSD).doQuery();
    }
    
}

package business;

import dataaccess.RemoveItemQuery;

public class RemoveItemRequest implements GroceryListRequestService {

    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        return new RemoveItemQuery(itemInformation, uSD).doQuery();
    }
    
}

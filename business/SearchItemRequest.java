package business;

import dataaccess.SearchItemQuery;

public class SearchItemRequest implements GroceryListRequestService{
    
    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        return new SearchItemQuery(itemInformation, uSD).doQuery();
    }
}

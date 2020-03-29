package business;

import dataaccess.ItemInformationInsertionQuery;

public class AddItemToGroceryListRequest implements GroceryListRequestService{
    
    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        boolean successful = false;
        ItemChecker itemChecker = new ItemChecker(itemInformation);
        
        if(itemChecker.checkItemInformation()){
            ItemInformationInsertionQuery insertionQuery = new ItemInformationInsertionQuery(itemInformation, uSD);
            successful = insertionQuery.doQuery();
        }
        
        return successful;
    }
}

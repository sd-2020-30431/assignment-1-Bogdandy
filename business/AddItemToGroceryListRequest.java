package business;

import dataaccess.ItemInformationInsertionQuery;

public class AddItemToGroceryListRequest implements DataModificationRequestService{
    
    @Override
    public boolean requestModification(ItemInformation data) {
        boolean successful = false;
        ItemChecker itemChecker = new ItemChecker(data);
        
        if(itemChecker.checkItemInformation()){
            ItemInformationInsertionQuery insertionQuery = new ItemInformationInsertionQuery(data);
            successful = insertionQuery.doQuery();
        }
        
        return successful;
    }
}

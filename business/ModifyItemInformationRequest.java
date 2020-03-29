package business;

import dataaccess.ItemInformationModificationQuery;

public class ModifyItemInformationRequest implements GroceryListRequestService{

    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        boolean successful = false;
        ItemChecker itemChecker = new ItemChecker(itemInformation);
        
        if(itemChecker.checkItemInformation()){
            ItemInformationModificationQuery modificationQuery = new ItemInformationModificationQuery(itemInformation, uSD);
            successful = modificationQuery.doQuery();
        }
        
        return successful;
    }
    
}

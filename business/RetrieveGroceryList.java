package business;

public class RetrieveGroceryList implements GroceryListRequestService{

    @Override
    public boolean requestModification(ItemInformation itemInformation, UserDataStructure uSD) {
        return false;
    }
    
}

package business;

import javax.swing.JOptionPane;

public class AddItemToGroceryListRequest implements DataModificationRequestService{

    @Override
    public void requestModification(ItemInformation data, int table) {
        JOptionPane.showMessageDialog(null, "MERGE");
    }
    
    
}

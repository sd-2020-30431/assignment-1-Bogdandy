package business;

import javax.swing.JOptionPane;

public class AddItemToGroceryListRequest implements DataModificationRequestService{

    @Override
    public void request(ItemInformation data, int table) {
        JOptionPane.showMessageDialog(null, "MERGE");
    }
    
    
}

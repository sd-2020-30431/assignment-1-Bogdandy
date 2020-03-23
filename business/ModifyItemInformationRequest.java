package business;

import javax.swing.JOptionPane;

public class ModifyItemInformationRequest implements DataModificationRequestService{

    @Override
    public void request(ItemInformation data, int table) {
        JOptionPane.showMessageDialog(null, "MERGE2");
    }
    
}

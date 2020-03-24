package business;

import javax.swing.JOptionPane;

public class ModifyItemInformationRequest implements DataModificationRequestService{

    @Override
    public void requestModification(ItemInformation data, int table) {
        JOptionPane.showMessageDialog(null, "MERGE2");
    }
    
}

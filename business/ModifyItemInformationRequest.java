package business;

import javax.swing.JOptionPane;

public class ModifyItemInformationRequest implements DataModificationRequestService{

    @Override
    public boolean requestModification(ItemInformation data) {
        JOptionPane.showMessageDialog(null, "MERGE2");
        return false;
    }
    
}

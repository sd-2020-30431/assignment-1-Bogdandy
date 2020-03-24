package business;

import javax.swing.JOptionPane;

public class ModifyItemInformationRequest implements DataModificationRequestService{

    @Override
    public void requestModification(ItemInformation data) {
        JOptionPane.showMessageDialog(null, "MERGE2");
    }
    
}

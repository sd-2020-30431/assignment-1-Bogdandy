package business;

import dataacess.javaconnect;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddItemToGroceryListRequest implements DataModificationRequestService{
    Connection conn = javaconnect.ConnectDb();
    ResultSet rs;
    PreparedStatement pst;
    
    @Override
    public void requestModification(ItemInformation data) {
        String sql = "Insert into grocerylist values (idGroceryList, ?, ?, ?, ?, ?, ?, ?)";
        DateToSQLDateConvertor dateConvertor = new DateToSQLDateConvertor();
        
        try{
            if(true){
                pst = conn.prepareStatement(sql);
                pst.setInt(1, data.getTableIndex());
                pst.setString(2, data.getItemName());
                pst.setInt(3, data.getQuantity());
                pst.setInt(4, data.getCaloricValue());
                pst.setDate(5, dateConvertor.convertDate(data.getPurchaseDate()));
                pst.setDate(6, dateConvertor.convertDate(data.getExpirationDate()));
                pst.setDate(7, dateConvertor.convertDate(data.getConsumptionDate()));
                
                pst.execute();
            
                JOptionPane.showMessageDialog(null,"Item added successfuly to the list!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Item couldn't be added to the list!\nPlease check if all the information is valid.");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error!\n" + ex);
        } catch (ParseException ex) {
            Logger.getLogger(AddItemToGroceryListRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
               // Close connection
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }   
    }
}

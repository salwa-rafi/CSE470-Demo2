/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.mysql.jdbc.Connection;
import static guardmanagementsystem.GuardManagementSystem.mainstage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class ShowControllerTest implements Initializable {

    @FXML
    private JFXButton back_btn;
    @FXML
    private JFXTextArea show;

    public static String GFID = null;
    public static LocalDate fromdate = null;
    public static LocalDate todate = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void testinitialize(URL url, ResourceBundle rb) {
        String p=" ";
        
        try {
            // TODO
            Connection con = (Connection) ConnectionManager.getConnection();
            String sql="SELECT * FROM `penalty` WHERE GFID='"+GFID+"' and penalty_date>='"+fromdate+"' and penalty_date<='"+todate+"'";
            ResultSet rs = null;
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(ShowControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                //Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(rs.next())
            {
                p=p+"গার্ড  জিএফআইডি : ";//guard gfid
                p=p+rs.getString("GFID");
                p=p+"\n";
                
                 p=p+"তারিখ : ";//date
                 p=p+rs.getString("penalty_date");
                 p=p+"\n";
                 
                 p=p+"পোস্টিং এরিয়া : ";//GUARD LOCATION
                 p=p+rs.getString("GUARD_LOCATION");
                 p=p+"\n";
                 
                  p=p+"এলাকা : ";//ZONE
                 p=p+rs.getString("ZONE");
                 p=p+"\n";
                 
                  p=p+"সময় : ";//TIME
                 p=p+rs.getString("TIME");
                 p=p+"\n";
                 
                  p=p+"পরিদর্শক জিএফআইডি : ";//INSPECTOR_GFID
                 p=p+rs.getString("INSPECTOR_GFID");
                 p=p+"\n";
                 
                  p=p+"গার্ড এর অবস্থা : ";//CONDITION_STATE
                 p=p+rs.getString("CONDITION_STATE");
                 p=p+"\n";
                 
                   p=p+"পরিদর্শন মন্তব্য : ";//REMARKS
                 p=p+rs.getString("REMARKS");
                 p=p+"\n";
                 
                 p=p+"পেনাল্টি  টাকা : ";//AMOUNT
                 p=p+rs.getString("AMOUNT");
                 p=p+"\n";
                 
                p=p+"---------------------------------------------------------------------------------\n";
               // p=p+rs.getString("condition_state");
            }
             
            // p=p+" \n ";
            // p=p+"\n";
           
             show.setText(p);
        } catch (SQLException ex) {
            Logger.getLogger(ShowControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back_btn_press(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PenaltyMain.fxml"));
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
        mainstage.setResizable(false);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class Admin_mainControllerTest implements Initializable {

    @FXML
    private Button guard_btn;
    @FXML
    private Button penalty_btn;
    @FXML
    private Button inventory_btn;
    @FXML
    private Button officeinventory_btn;
    
    Stage stage=new Stage();

    /**
     * Initializes the controller class.
     */
    @Override
    public void testinitialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guard_btn_press(ActionEvent event) {
       
       
    
        try {
            //System.out.print("start");
             Pane root  = FXMLLoader.load(getClass().getResource("AllGuard.fxml"));
             Scene scene = new Scene(root);
             //scene.getStylesheets().add(getClass().getResource("bootstrap3.css").toExternalForm());
             
              GuardManagementSystem.mainstage.setScene(scene);
            
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        GuardManagementSystem.mainstage.setResizable(false);
        GuardManagementSystem.mainstage.setTitle("Guard Management System");
        //GuardForceProject.mainstage.initStyle(StageStyle.TRANSPARENT);
       
        //stage.setX(350); 
       // stage.setY(32);  
        GuardManagementSystem.mainstage.show();
      
        
    }

    @FXML
    private void penalty_btn_press(ActionEvent event) {
       
      
        try {
             Pane root  = FXMLLoader.load(getClass().getResource("PenaltyMain.fxml"));
             Scene scene = new Scene(root);
  
             GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }
    
}

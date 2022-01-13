/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class Search_guardController implements Initializable {

    @FXML
    private Button add_photo_btn;
    @FXML
    private TextField GFID_TF;
    @FXML
    private TextField NID_TF;
    @FXML
    private TextField NAME_TF;
    @FXML
    private TextField FATHER_TF;
    @FXML
    private TextField MOTHER_TF;
    @FXML
    private TextField designation;
    @FXML
    private TextField salary;
    @FXML
    private TextField salary_type;
    @FXML
    private TextField contact;
    @FXML
    private TextField remarks;
    @FXML
    private TextField ward;
    @FXML
    private TextField gram;
    @FXML
    private TextField jilla;
    @FXML
    private TextField thana;
    @FXML
    private TextField posting;
    @FXML
    private TextField education;
    @FXML
    private TextField experience;
    @FXML
    private TextField height;
    @FXML
    private Label label;
    @FXML
    private JFXButton back_btn;
    @FXML
    private JFXButton delete_btn;
    @FXML
    private JFXButton edit_btn;
    @FXML
    private JFXDatePicker DOB_TF;
    @FXML
    private JFXDatePicker joining;
    @FXML
    private JFXButton update_btn;
    @FXML
    private JFXButton search_btn;
    
    public static String gfid; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setupforedit()
    {
            GFID_TF.setDisable(false);
            NID_TF.setDisable(false);
            NAME_TF.setDisable(false);
            DOB_TF.setDisable(false);
            FATHER_TF.setDisable(false);
            MOTHER_TF.setDisable(false);
            joining.setDisable(false);
            designation.setDisable(false);
            salary.setDisable(false);
            salary_type.setDisable(false);
            contact.setDisable(false);
            remarks.setDisable(false);
            ward.setDisable(false);
            gram.setDisable(false);
            jilla.setDisable(false);
            thana.setDisable(false);
            posting.setDisable(false);
            education.setDisable(false);
            experience.setDisable(false);
            height.setDisable(false);
            //reference.setDisable(false);
            add_photo_btn.setVisible(true);
            //save_btn.setVisible(false);
            delete_btn.setVisible(false);
            //save_btn.setVisible(false);
            edit_btn.setVisible(false);
            update_btn.setVisible(true);
    }
     public void setupforsearch()
    {
            GFID_TF.setDisable(true);
            NID_TF.setDisable(true);
            NAME_TF.setDisable(true);
            DOB_TF.setDisable(true);
            FATHER_TF.setDisable(true);
            MOTHER_TF.setDisable(true);
            joining.setDisable(true);
            designation.setDisable(true);
            salary.setDisable(true);
            salary_type.setDisable(true);
            contact.setDisable(true);
            remarks.setDisable(true);
            ward.setDisable(true);
            gram.setDisable(true);
            jilla.setDisable(true);
            thana.setDisable(true);
            posting.setDisable(true);
            education.setDisable(true);
            experience.setDisable(true);
            height.setDisable(true);
            //reference.setDisable(true);
            add_photo_btn.setVisible(false);
            //save_btn.setVisible(false);
            edit_btn.setVisible(true);
            delete_btn.setVisible(true);
            //save_btn.setVisible(false);
            update_btn.setVisible(true);
    }

    @FXML
    private void add_photo_btn_press(ActionEvent event) {
    }

    @FXML
    private void back_btn_press(ActionEvent event) {
        try {
             Pane root  = FXMLLoader.load(getClass().getResource("AllGuard.fxml"));
             Scene scene = new Scene(root);
             //scene.getStylesheets().add(getClass().getResource("bootstrap3.css").toExternalForm());
            // scene.setFill(Color.AQUA);
             
             GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
         //stage.setX(350); 
        //stage.setY(32);  
        //GuardForceProject.mainstage.initStyle(StageStyle.TRANSPARENT);    
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void delete_btn_press(ActionEvent event) {
    }


    @FXML
    private void edit_btn_press(ActionEvent event) {
        setupforedit();
    }

    @FXML
     private void update_btn_press(ActionEvent event) throws SQLException {
        Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
        
        String GFID=GFID_TF.getText();
     String NID=NID_TF.getText();
     String NAME=NAME_TF.getText();
     LocalDate DOB=DOB_TF.getValue();
     String FATHER=FATHER_TF.getText();
     String MOTHER=MOTHER_TF.getText();
     LocalDate joining_v=joining.getValue();
     String designation_v=designation.getText();
     String salary_type_v=salary_type.getText();
     String remarks_v=remarks.getText();
     String ward_v=ward.getText();
     String gram_v=gram.getText();
     String jilla_v=jilla.getText();
     String thana_v=thana.getText();
     String posting_v=posting.getText();
     String education_v=education.getText();
     String experience_v=experience.getText();
     String height_v=height.getText();
    // String reference_v=reference.getText();
     
      String contact_v;
      
      contact_v=contact.getText();
        String salary_v=salary.getText();
      
     
     con = ConnectionManager.getConnection();
    String sql="UPDATE EMPLOYEE\n" +
    "SET GFID='"+GFID+"',\n" +
    "NID='"+NID+"',\n" +
    "NAME='"+NAME+"',\n" +
    "FATHER_NAME='"+FATHER+"',\n" +
    "MOTHER_NAME='"+MOTHER+"',\n" +
    "SALARY='"+salary_v+"',\n" +
    "SALARY_TYPE='"+salary_type_v+"',\n" +
    "CONTACT='"+contact_v+"',\n" +
    "HEIGHT='"+height_v+"',\n" +
    "EDUCATION='"+education_v+"',\n" +
    "EXPERIENCE='"+experience_v+"',\n" +
    "GRAM_ADDRESS='"+gram_v+"',\n" +
    "THANA_ADDRESS='"+thana_v+"',\n" +
    "WARD_ADDRESS='"+ward_v+"',\n" +
    "JILLA_ADDRESS='"+jilla_v+"',\n" +
    "POSTING='"+posting_v+"',\n" +
   // "REFERENCE='"+reference_v+"',\n" +
    "REMARKS='"+remarks_v+"'\n" +
    "WHERE GFID='"+GFID+"'";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
            //Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    con.close();
    
        label.setText("UPDATED SUCCESSFULLY");
        setupforsearch();
    }
    
    @FXML
    private void search_btn_press(ActionEvent event) throws SQLException {
        
      String search_field=gfid;
        
     
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    {
         con = ConnectionManager.getConnection();
        String sql="SELECT * FROM employee\n" +
        "WHERE GFID='"+search_field+"'";
        stmt = con.createStatement();
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
          //  Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
while(rs.next())
{
    String gf=rs.getString("GFID");
    GFID_TF.setText(gf);
    
     String NID=rs.getString("NID");
    NID_TF.setText(NID);
    
    String NAME=rs.getString("NAME");
    NAME_TF.setText(NAME);
    
    String FATHER=rs.getString("FATHER_NAME");
    FATHER_TF.setText(FATHER);

    String MOTHER=rs.getString("MOTHER_NAME");
    MOTHER_TF.setText(MOTHER);
    
   // String DOB=rs.getString("DOB");
    //DOB_TF.setText(DOB);
    
   // String joining_v=rs.getString("joining");
    //joining.setText(joining_v);
    
    String salary_type_v=rs.getString("salary_type");
    salary_type.setText(salary_type_v);
    
    String remarks_v=rs.getString("remarks");
    remarks.setText(remarks_v);
    
    String ward_v=rs.getString("ward_address");
    ward.setText(ward_v);
    
    String gram_v=rs.getString("gram_address");
    gram.setText(gram_v);
    
    String thana_v =rs.getString("thana_address");
    thana.setText(thana_v);
    
    String jilla_v=rs.getString("jilla_address");
    jilla.setText(jilla_v);
    
    String posting_v=rs.getString("posting");
    posting.setText(posting_v);
    
    String education_v=rs.getString("education");
    education.setText(education_v);
    
    String experience_v=rs.getString("EXPERIENCE");
    experience.setText(experience_v);
    
    String height_v=rs.getString("height");
    height.setText(height_v);
    
    //String reference_v=rs.getString("reference");
   // reference.setText(reference_v);
    
    
    
    String contact_v=rs.getString("contact");
    contact.setText(contact_v);
    
    String salary_v=rs.getString("salary");
    salary.setText(salary_v);
    
   
    
    String designation_v=rs.getString("designation");
    designation.setText(designation_v);
    
//    
//    String =rs.getString("");
//    .setText();
//    
//JOptionPane.showMessageDialog(null, "success");
//System.out.println(gf);
    setupforsearch();
}
con.close();
    }
    
    }
    
}

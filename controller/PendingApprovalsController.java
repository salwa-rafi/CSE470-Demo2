/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class PendingApprovalsController implements Initializable {
    
    
ObservableList <PendingApprovalsController.EmployeeTable> elist = FXCollections.observableArrayList();
    @FXML
    private JFXButton pending_btn;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String>ALLG_gfid;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String> ALLG_name;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String> ALLG_address;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String> ALLG_salary;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String> ALLG_location;
    @FXML
    private TableColumn<PendingApprovalsController.EmployeeTable,String> ALLG_remarks;
    @FXML
    private TableView<PendingApprovalsController.EmployeeTable>ALLG_table;
    Connection con;
    Statement stm;
    ResultSet rest;
    @FXML
    private JFXButton view;
    @FXML
    private JFXTextField gfid;
    @FXML
    private JFXButton cancel_btn;
    @FXML
    private JFXButton approve_btn;
    @FXML
    private Label label;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   private void initCol() {
    ALLG_gfid.setCellValueFactory(new PropertyValueFactory<>("GFID"));
    ALLG_name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
    ALLG_address.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
    ALLG_salary.setCellValueFactory(new PropertyValueFactory<>("SALARY"));
    ALLG_location.setCellValueFactory(new PropertyValueFactory<>("LOCATION"));
    ALLG_remarks.setCellValueFactory(new PropertyValueFactory<>("REMARKS"));
    }
    private void show_btn_press(ActionEvent event) throws SQLException {
            }
           private void employee2loadData() throws SQLException {
        String qu = "SELECT GFID , NAME , JILLA_ADDRESS , FATHER_NAME, MOTHER_NAME,\n"
                + "NID, DOB,SALARY,SALARY_TYPE,CONTACT, HEIGHT, EDUCATION,EXPERIENCE, \n"
                + "GRAM_ADDRESS,THANA_ADDRESS,WARD_ADDRESS,JILLA_ADDRESS, \n"
                + "POSTING,REMARKS,REFERENCE,DESIGNATION,JOINING FROM employee"
                + " where status='PENDING'";
        con= ConnectionManager.getConnection();
        stm=con.createStatement();
        rest = stm.executeQuery(qu);
        try {
            while (rest.next()) {
                String stgfid = rest.getString("GFID");
                String stname = rest.getString("NAME");
                String stfather = rest.getString("FATHER_NAME");
                String stmother = rest.getString("MOTHER_NAME");
                String stnid= rest.getString("NID");
                String stdob= rest.getString("DOB");
                String stsalarytype= rest.getString("SALARY_TYPE");
                String stsalary= rest.getString("SALARY");
                String stjoining= rest.getString("JOINING");
                String stcontact= rest.getString("CONTACT");
                String stheight= rest.getString("HEIGHT");
                String steducation= rest.getString("EDUCATION");
                String stexperience= rest.getString("EXPERIENCE");
                String stgram= rest.getString("GRAM_ADDRESS");
                String stthana= rest.getString("THANA_ADDRESS");
                String stward= rest.getString("WARD_ADDRESS");
                String stjilla= rest.getString("JILLA_ADDRESS");
                String stposting= rest.getString("POSTING");
                String stremarks= rest.getString("REMARKS");
                String streference= rest.getString("REFERENCE");
                String stdesignation= rest.getString("DESIGNATION");  
                String stcname="Name: "+stname+"\n"
                        +"DOB: "+stdob+"\n"
                        +"Height: "+stheight+"\n"
                        +"Education: "+steducation+"\n"
                        +"Experience: "+stexperience+"\n"
                        +"NID: "+stnid+"\n"
                        +"Mobile: "+stcontact;                        
                String staddress= "Father: "+stfather+"\n"
                        +"Mother: "+stmother+"\n"
                        +"Gram: "+stgram+"\n"
                        +"Ward: "+stward+"\n"
                        +"Thana: "+stthana+"\n"
                        +"Zila: "+stjilla+"\n";
                String stlocation= stposting;
                String stcremarks= "Remarks: "+stremarks;
                String stcsalary="Type: "+stsalarytype+"\n"+"Amount: "+stsalary;
                        
      PendingApprovalsController.EmployeeTable Employee = new PendingApprovalsController.EmployeeTable (stgfid,stcname,staddress,stcsalary,stlocation,stcremarks);
      elist.add(Employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllGuardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ALLG_table.getItems().addAll(elist);
    }

    @FXML
    private void pending_btn_press(ActionEvent event) {
         try {
             Pane root  = FXMLLoader.load(getClass().getResource("AllGuard.fxml"));
             Scene scene = new Scene(root);
             GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void view_press(ActionEvent event) throws SQLException {
        elist.clear();
        ALLG_table.getItems().clear();
        initCol();
        employee2loadData();
    }

    @FXML
    private void cancel_btn_press(ActionEvent event) throws SQLException {
        String s=gfid.getText();
        
        if(s.isEmpty())
        {
            label.setText("ENTER A GFID");
        }
        else
        {
            Connection con = ConnectionManager.getConnection();
            String sql="DELETE employee\n" +
            "set STATUS='PENDING' AND \n" +
            " where gfid='"+s+"'";
            
            Statement stmt;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
            }

            con.close();
            label.setText("Not Approved");
        }
    }

    @FXML
    private void approve_btn_press(ActionEvent event) throws SQLException {
        
        String s=gfid.getText();
        
        if(s.isEmpty())
        {
            label.setText("ENTER A GFID");
        }
        else
        {
            Connection con = ConnectionManager.getConnection();
            String sql="update employee\n" +
            "set STATUS='approved'\n" +
            " where gfid='"+s+"'";
            
            Statement stmt;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                //Logger.getLogger(PenaltyController.class.getName()).log(Level.SEVERE, null, ex);
            }

            con.close();
            label.setText("Approved");
        }
        

    }
        public class EmployeeTable {
            private final String GFID;
            private final String NAME;
            private final String ADDRESS;
            private final String SALARY;
            private final String LOCATION;
            private final String REMARKS;

        public EmployeeTable(String GFID, String NAME, String ADDRESS, String SALARY, String LOCATION, String REMARKS) {
            this.GFID = GFID;
            this.NAME = NAME;
            this.ADDRESS = ADDRESS;
            this.SALARY = SALARY;
            this.LOCATION = LOCATION;
            this.REMARKS = REMARKS;
        }

        public String getGFID() {
            return GFID;
        }

        public String getNAME() {
            return NAME;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public String getSALARY() {
            return SALARY;
        }

        public String getLOCATION() {
            return LOCATION;
        }

        public String getREMARKS() {
            return REMARKS;
        }
    
}
}

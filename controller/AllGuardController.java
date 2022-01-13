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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AllGuardController implements Initializable {

    @FXML
    private JFXButton AllGaurdBack_btn;
    @FXML
    private JFXButton AllGuardSearch_bth;
    @FXML
    private JFXButton AllGuardAddNew_btn;
    @FXML
    private JFXButton AllGuardApproval_btn;
    ObservableList<EmployeeTable> elist = FXCollections.observableArrayList();
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_gfid;
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_name;
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_address;
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_salary;
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_location;
    @FXML
    private TableColumn<EmployeeTable, String> ALLG_remarks;
    @FXML
    private TableView<EmployeeTable> ALLG_table;
    @FXML
    private Button showallemp_btn;
    @FXML
    private JFXTextField gfid;
    private Label label;
    @FXML
    private JFXButton main_search;

    public String state;
    @FXML
    private Label p;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void initCol() {
        ALLG_gfid.setCellValueFactory(new PropertyValueFactory<>("GFID"));
        ALLG_name.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        ALLG_address.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
        ALLG_salary.setCellValueFactory(new PropertyValueFactory<>("SALARY"));
        ALLG_location.setCellValueFactory(new PropertyValueFactory<>("LOCATION"));
        ALLG_remarks.setCellValueFactory(new PropertyValueFactory<>("REMARKS"));
    }

    private void employee2loadData() throws SQLException {
        Statement stm;
        ResultSet rest;
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionManager.getConnection();
        String qu;
        if (state.equals("show all")) {
            qu = "SELECT GFID , NAME , JILLA_ADDRESS , FATHER_NAME, MOTHER_NAME,\n"
                    + "NID, DOB,SALARY,SALARY_TYPE,CONTACT, HEIGHT, EDUCATION,EXPERIENCE, \n"
                    + "GRAM_ADDRESS,THANA_ADDRESS,WARD_ADDRESS,JILLA_ADDRESS, \n"
                    + "POSTING,REMARKS,REFERENCE,DESIGNATION,JOINING FROM employee WHERE STATUS='APPROVED'";
        } else {
            qu = "SELECT GFID , NAME , JILLA_ADDRESS , FATHER_NAME, MOTHER_NAME,\n"
                    + "NID, DOB,SALARY,SALARY_TYPE,CONTACT, HEIGHT, EDUCATION,EXPERIENCE, \n"
                    + "GRAM_ADDRESS,THANA_ADDRESS,WARD_ADDRESS,JILLA_ADDRESS, \n"
                    + "POSTING,REMARKS,REFERENCE,DESIGNATION,JOINING FROM employee"
                    + " where gfid='" + gfid.getText().toString() + "' AND STATUS='APPROVED'";
        }

        con = (com.mysql.jdbc.Connection) ConnectionManager.getConnection();
        stm = con.createStatement();
        rest = stm.executeQuery(qu);
        try {
            while (rest.next()) {
                String stgfid = rest.getString("GFID");
                String stname = rest.getString("NAME");
                String stfather = rest.getString("FATHER_NAME");
                String stmother = rest.getString("MOTHER_NAME");
                String stnid = rest.getString("NID");
                String stdob = rest.getString("DOB");
                String stsalarytype = rest.getString("SALARY_TYPE");
                String stsalary = rest.getString("SALARY");
                String stjoining = rest.getString("JOINING");
                String stcontact = rest.getString("CONTACT");
                String stheight = rest.getString("HEIGHT");
                String steducation = rest.getString("EDUCATION");
                String stexperience = rest.getString("EXPERIENCE");
                String stgram = rest.getString("GRAM_ADDRESS");
                String stthana = rest.getString("THANA_ADDRESS");
                String stward = rest.getString("WARD_ADDRESS");
                String stjilla = rest.getString("JILLA_ADDRESS");
                String stposting = rest.getString("POSTING");
                String stremarks = rest.getString("REMARKS");
                String streference = rest.getString("REFERENCE");
                String stdesignation = rest.getString("DESIGNATION");
                String stcname = "Name: " + stname + "\n"
                        + "DOB: " + stdob + "\n"
                        + "Height: " + stheight + "\n"
                        + "Education: " + steducation + "\n"
                        + "Experience: " + stexperience + "\n"
                        + "NID: " + stnid + "\n"
                        + "Mobile: " + stcontact;
                String staddress = "Father: " + stfather + "\n"
                        + "Mother: " + stmother + "\n"
                        + "Gram: " + stgram + "\n"
                        + "Ward: " + stward + "\n"
                        + "Thana: " + stthana + "\n"
                        + "Zila: " + stjilla + "\n";
                String stlocation = stposting;
                String stcremarks = "Remarks: " + stremarks;
                String stcsalary = "Type: " + stsalarytype + "\n" + "Amount: " + stsalary;

                AllGuardController.EmployeeTable Employee = new AllGuardController.EmployeeTable(stgfid, stcname, staddress, stcsalary, stlocation, stcremarks);
                elist.add(Employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllGuardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ALLG_table.getItems().addAll(elist);
        elist.clear();
        con.close();
    }

    @FXML
    private void showallemp(ActionEvent event) throws SQLException {
        ALLG_table.getItems().clear();

        state = "show all";

        initCol();

        employee2loadData();

    }

    @FXML
    private void AllGaurdBack_btn_press(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void AllGuardSearch_bth_press(ActionEvent event) {
        try {
            String s = gfid.getText();
            if (s.isEmpty()) {
                label.setText("ENTER GFID");
            } else {
                Search_guardController.gfid = s;
                Pane root = FXMLLoader.load(getClass().getResource("search_guard.fxml"));
                Scene scene = new Scene(root);
                GuardManagementSystem.mainstage.setScene(scene);

            }

        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void AllGuardAddNew_btn_press(ActionEvent event) {

        try {
            Pane root = FXMLLoader.load(getClass().getResource("add.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void AllGuardApproval_btn_press(ActionEvent event) {

        try {
            Pane root = FXMLLoader.load(getClass().getResource("PendingApprovals.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void main_search_press(ActionEvent event) throws SQLException {
        ALLG_table.getItems().clear();
        state = "main_search";

        initCol();
        employee2loadData();
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

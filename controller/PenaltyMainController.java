/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class PenaltyMainController implements Initializable {

    ObservableList<PenaltyMainController.main_penalty> penaltylist = FXCollections.observableArrayList();
    @FXML
    private JFXButton close;
    @FXML
    private JFXButton penalty_back;
    @FXML
    private JFXButton penalty_search;
    @FXML
    private JFXButton add_new_penalty;
    @FXML
    private JFXTextField gfid;
    @FXML
    private DatePicker date_picker;
    @FXML
    private JFXButton set_penalty;
    @FXML
    private JFXButton monthly_report_btn;
    @FXML
    private JFXComboBox<String> month;
    @FXML
    private JFXComboBox<String> year;
    @FXML
    private TableColumn<main_penalty, String> year_c;
    @FXML
    private TableColumn<main_penalty, String> month_c;
    @FXML
    private TableColumn<main_penalty, String> gfid_c;
    @FXML
    private TableColumn<main_penalty, String> quantity_c;
    @FXML
    private TableColumn<main_penalty, String> amount_c;
    @FXML
    private TableColumn<main_penalty, String> paid_c;
    @FXML
    private TableColumn<main_penalty, String> serial_c;
    @FXML
    private TableView<main_penalty> main_penalty_table;

    String getmonth;
    String getyear;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXDatePicker from;
    @FXML
    private JFXDatePicker to;
    @FXML
    private JFXTextField gfid_wave;
    @FXML
    private Label label;
    @FXML
    private JFXButton wave_btn;
    @FXML
    private TableColumn<main_penalty, String> wave_c;
    @FXML
    private JFXButton wave_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> option1
                = FXCollections.observableArrayList(
                        "JANUARY",
                        "FEBRUARY",
                        "MARCH",
                        "APRIL",
                        "MAY",
                        "JUNE",
                        "JULY",
                        "AUGUST",
                        "SEPTEMBER",
                        "OCTOBER",
                        "NOVEMBER",
                        "DECEMBER"
                );
        //month
        month.setItems(option1);

        ObservableList<String> option2
                = FXCollections.observableArrayList(
                        "2019",
                        "2020",
                        "2021",
                        "2022",
                        "2023",
                        "2024",
                        "2025",
                        "2026",
                        "2027",
                        "2028",
                        "2029",
                        "2030",
                        "2031",
                        "2032",
                        "2033",
                        "2034",
                        "2035",
                        "2036",
                        "2037",
                        "2038",
                        "2039"
                );
        //month
        year.setItems(option2);
        month.getSelectionModel().select(0);
        year.getSelectionModel().select(1);
    }

    public void initcol() {
        serial_c.setCellValueFactory(new PropertyValueFactory<>("serial"));
        year_c.setCellValueFactory(new PropertyValueFactory<>("year"));
        month_c.setCellValueFactory(new PropertyValueFactory<>("month"));
        gfid_c.setCellValueFactory(new PropertyValueFactory<>("gfid"));
        quantity_c.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        amount_c.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paid_c.setCellValueFactory(new PropertyValueFactory<>("paid"));
        wave_c.setCellValueFactory(new PropertyValueFactory<>("wave"));

    }

    public void loaddata2() {

        String gfid_wave_s1 = gfid_wave.getText();
        if (gfid_wave_s1.isEmpty()) {
            label.setText("Please Enter a GFID");
        } else {
            try {

                int serial_i = 1;
                String serial_s;
                String year_s;
                String month_s;
                String quantity_s;
                String amount_s;
                String paid_s;
                String gfid_s;

                Connection con = (Connection) ConnectionManager.getConnection();
                String sql;
                sql = "select * from monthly_report "
                        + " where gfid ='" + gfid_wave_s1 + "'";

                ResultSet rs = null;
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rs = stmt.executeQuery(sql);
                    //label.setText("query complete");
                } catch (SQLException ex) {
                    //Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (rs.next()) {

                    serial_s = String.valueOf(serial_i);
                    serial_i = serial_i + 1;
                    month_s = rs.getString("month");
                    year_s = rs.getString("year");
                    gfid_s = rs.getString("gfid");
                    quantity_s = rs.getString("quantity");
                    amount_s = rs.getString("amount");
                    paid_s = rs.getString("paid");
                    String wave_s = String.valueOf(Integer.parseInt(amount_s.toString()) - Integer.parseInt(paid_s.toString()));
                    if (Integer.parseInt(amount_s.toString()) - Integer.parseInt(paid_s.toString()) > 0) {
                        PenaltyMainController.main_penalty mc;
                        mc = new PenaltyMainController.main_penalty(serial_s, month_s, year_s, gfid_s, quantity_s, amount_s, paid_s, wave_s);
                        penaltylist.add(mc);
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            main_penalty_table.getItems().addAll(penaltylist);

        }

    }

    public void loaddata() {

        getmonth = month.getValue();
        getyear = year.getValue();
        if (getmonth.isEmpty()) {
            label.setText("Please Select a Month");
        } else if (getyear.isEmpty()) {
            label.setText("Please Select a Year");
        } else {
            try {

                int serial_i = 1;
                String serial_s;
                String year_s;
                String month_s;
                String quantity_s;
                String amount_s;
                String paid_s;
                String gfid_s;

                Connection con = (Connection) ConnectionManager.getConnection();
                String sql;
                sql = "select * from monthly_report "
                        + " where year='" + getyear + "'"
                        + " and month='" + getmonth + "'";

                ResultSet rs = null;
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    rs = stmt.executeQuery(sql);
                } catch (SQLException ex) {
                }
                while (rs.next()) {
                    serial_s = String.valueOf(serial_i);
                    serial_i = serial_i + 1;
                    month_s = rs.getString("month");
                    year_s = rs.getString("year");
                    gfid_s = rs.getString("gfid");
                    quantity_s = rs.getString("quantity");
                    amount_s = rs.getString("amount");
                    paid_s = rs.getString("paid");
                    String wave_s = String.valueOf(Integer.parseInt(amount_s.toString()) - Integer.parseInt(paid_s.toString()));
                    PenaltyMainController.main_penalty mc;
                    mc = new PenaltyMainController.main_penalty(serial_s, month_s, year_s, gfid_s, quantity_s, amount_s, paid_s, wave_s);
                    penaltylist.add(mc);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            main_penalty_table.getItems().addAll(penaltylist);
        }
    }

    @FXML
    private void close_press(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("PenaltyMain.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void penalty_back_press(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void penalty_search_press(ActionEvent event) {
        ShowController.GFID = gfid.getText();
        ShowController.fromdate = from.getValue();
        ShowController.todate = to.getValue();
        try {
            Pane root = FXMLLoader.load(getClass().getResource("show.fxml"));
            Scene scene = new Scene(root);

            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void add_new_penalty_press(ActionEvent event) {

        try {
            Pane root = FXMLLoader.load(getClass().getResource("AddPenalty.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void set_penalty_press(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("set_penalty.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void monthly_report_btn_press(ActionEvent event) {
        penaltylist.clear();
        main_penalty_table.getItems().clear();
        initcol();
        loaddata();
    }

    @FXML
    private void wave_btn_press(ActionEvent event) throws SQLException {
        String gfid_wave_s = gfid_wave.getText();
        int wave_amount = 0;
        try {

            wave_amount = Integer.parseInt(amount.getText());
        } catch (Exception ex) {
            label.setText("please enter a valid amount");
        }
        //        try{

        getmonth = month.getValue();
        getyear = year.getValue();

        if (getmonth.isEmpty()) {
            label.setText("please select a month");
        } else if (getyear.isEmpty()) {
            label.setText("please select a year");
        } else if (wave_amount == 0) {
            label.setText("please enter an amount");
        } else if (gfid_wave_s.isEmpty()) {
            label.setText("please enter a GFID");
        } else {
            Connection con = (Connection) ConnectionManager.getConnection();
            String sql = null;
            //sql=""
            sql = "UPDATE `monthly_report`\n"
                    + "SET amount=amount+'" + 0 + "',\n"
                    + "quantity=quantity+'0',\n"
                    + "paid=paid-'" + wave_amount + "'\n"
                    + "where GFID='" + gfid_wave_s + "'\n"
                    + "and month='" + getmonth + "'\n"
                    + "and year='" + getyear + "';";

            ResultSet rs = null;
            Statement stmt = null;

            stmt = con.createStatement();

            stmt.executeUpdate(sql);
            con.close();
            label.setText("Wave Successful: "+gfid_wave_s);
        }

    }

    @FXML
    private void wave_search_press(ActionEvent event) {
        penaltylist.clear();
        main_penalty_table.getItems().clear();
        initcol();
        loaddata2();
    }

    public class main_penalty {

        String serial;
        String month;
        String year;
        String gfid;
        String quantity;
        String amount;
        String paid;
        String wave;

        public main_penalty(String serial, String month, String year, String gfid, String quantity, String amount, String paid, String wave) {
            this.serial = serial;
            this.month = month;
            this.year = year;
            this.gfid = gfid;
            this.quantity = quantity;
            this.amount = amount;
            this.paid = paid;
            this.wave = wave;
        }

        public String getSerial() {
            return serial;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public String getGfid() {
            return gfid;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getAmount() {
            return amount;
        }

        public String getPaid() {
            return paid;
        }

        public String getWave() {
            return wave;
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static guardmanagementsystem.GuardManagementSystem.mainstage;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class Set_penaltyController implements Initializable {

    public static String sleep_s;
    public static String shirt_s;
    public static String belt_s;
    public static String bashi_s;
    public static String id_s;
    public static String hair_s;
    public static String shave_s;
    public static String boot_s;
    public static String polish_s;
    public static String civil_s;
    public static String appulate_s;
    public static String nameplate_s;
    public static String dayitto_s;
    public static String dirty_dress_s;
    public static String no_dress_s;
    public static String iron_s;
    public static String absent_s;

    @FXML
    private Label l2;
    @FXML
    private JFXButton back_btn;
    @FXML
    private JFXButton confirm_btn;
    @FXML
    private JFXTextField sleep;
    @FXML
    private JFXTextField shirt;
    @FXML
    private JFXTextField belt;
    @FXML
    private JFXTextField bashi;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField hair;
    @FXML
    private JFXTextField shave;
    @FXML
    private JFXTextField boot;
    @FXML
    private JFXTextField polish;
    @FXML
    private JFXTextField civil;
    @FXML
    private JFXTextField appulate;
    @FXML
    private JFXTextField nameplate;
    @FXML
    private JFXButton con_rec;
    @FXML
    private Label label;
    @FXML
    private JFXButton show_btn;
    @FXML
    private JFXTextField dayitto;
    @FXML
    private JFXTextField dirty_dress;
    @FXML
    private JFXTextField no_dress;
    @FXML
    private JFXTextField iron;
    @FXML
    private JFXTextField absent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //disable();
        //label.setText("disabled");
        // TODO
    }

    @FXML
    private void back_btn_press(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PenaltyMain.fxml"));
        Scene scene = new Scene(root);
        mainstage.setScene(scene);
        mainstage.show();
        mainstage.setResizable(false);
    }

    public void enable() {
        sleep.setDisable(false);
        belt.setDisable(false);
        bashi.setDisable(false);
        id.setDisable(false);
        hair.setDisable(false);
        shave.setDisable(false);
        boot.setDisable(false);
        polish.setDisable(false);
        civil.setDisable(false);
        appulate.setDisable(false);
        nameplate.setDisable(false);
        shirt.setDisable(false);
        dayitto.setDisable(false);
        dirty_dress.setDisable(false);
        no_dress.setDisable(false);
        iron.setDisable(false);
        absent.setDisable(false);

    }

    public void disable() {

        sleep.setDisable(true);
        belt.setDisable(true);
        bashi.setDisable(true);
        id.setDisable(true);
        hair.setDisable(true);
        shave.setDisable(true);
        boot.setDisable(true);
        polish.setDisable(true);
        civil.setDisable(true);
        appulate.setDisable(true);
        nameplate.setDisable(true);
        shirt.setDisable(true);
        dayitto.setDisable(true);
        dirty_dress.setDisable(true);
        no_dress.setDisable(true);
        iron.setDisable(true);
        absent.setDisable(true);
    }

    public void getvalue() {
        sleep_s = sleep.getText();
        shirt_s = shirt.getText();
        belt_s = belt.getText();
        bashi_s = bashi.getText();
        id_s = id.getText();
        hair_s = hair.getText();
        shave_s = shave.getText();
        boot_s = boot.getText();
        polish_s = polish.getText();
        civil_s = civil.getText();
        appulate_s = appulate.getText();
        nameplate_s = nameplate.getText();
        dayitto_s=dayitto.getText();
        dirty_dress_s=dirty_dress.getText();
        no_dress_s=no_dress.getText();
        iron_s=iron.getText();
        absent_s=absent.getText();
        
    }

    @FXML
    private void confirm_btn_press(ActionEvent event) throws SQLException {

        getvalue();

        Connection con = ConnectionManager.getConnection();
        String sql = "INSERT INTO `set_penalty`(`sleep`, `belt`, `bashi`, `dayitto`, `dirty_dress`, `no_dress`, `iron`, `absent`, `id`, `hair`, `shave`, `boot`, `polish`, `civil`, `appulate` ,  `nameplate`) "
                + "VALUES "
                + "('" + sleep_s + "','" + belt_s + "','" + bashi_s + "','" + dayitto_s+ "','" + dirty_dress_s+ "','" + no_dress_s+ "','" + iron_s+ "','" + absent_s+ "','" + id_s + "','" + hair_s + "','" + shave_s + "','" + boot_s + "','" + polish_s + "','" + civil_s + "','" + appulate_s + "','" + nameplate_s + "')";

        String sql1 = "UPDATE `set_penalty` SET "
                + "sleep='" + sleep_s + "',"
                + "belt='" + belt_s + "',"
                + "bashi='" + bashi_s + "',"
                + "dayitto='" + dayitto_s + "',"
                + "dirty_dress='" + dirty_dress_s + "',"
                + "no_dress='" + no_dress_s + "',"
                + "iron='" + iron_s + "',"
                + "absent='" + absent_s + "',"
                + "id='" + id_s + "',"
                + "hair='" + hair_s + "',shave='" + shave_s + "',"
                + "boot='" + boot_s + "',polish='" + polish_s + "',"
                + "civil='" + civil_s + "',appulate='" + belt_s + "',"
                + "nameplate='" + nameplate_s + "',shirt='" + shirt_s + "'";

        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(Set_penaltyController.class.getName()).log(Level.SEVERE, null, ex);
        }

        con.close();

        label.setText("updated");
        disable();

    }

    public void fetch() {
        int sleep_i = 0;
        int belt_i = 0;
        int bashi_i = 0;
        int id_i = 0;
        int hair_i = 0;
        int shave_i = 0;
        int boot_i = 0;
        int polish_i = 0;
        int civil_i = 0;
        int appulate_i = 0;
        int nameplate_i = 0;
        int shirt_i = 0;
        int dayitto_i = 0;
        int dirty_dress_i = 0;
        int no_dress_i = 0;
        int iron_i = 0;
        int absent_i = 0;
        try {
            // TODO
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionManager.getConnection();
            String sql = "SELECT * FROM set_penalty";
            ResultSet rs = null;
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(PenaltyMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(PenaltyMainController.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (rs.next()) {
                sleep_i = rs.getInt("sleep");
                belt_i = rs.getInt("belt");
                bashi_i = rs.getInt("bashi");
                id_i = rs.getInt("id");
                hair_i = rs.getInt("hair");
                shave_i = rs.getInt("shave");
                boot_i = rs.getInt("boot");
                polish_i = rs.getInt("polish");
                civil_i = rs.getInt("civil");
                appulate_i = rs.getInt("appulate");
                nameplate_i = rs.getInt("nameplate");
                shirt_i = rs.getInt("shirt");
                
                dayitto_i = rs.getInt("dayitto");
                dirty_dress_i = rs.getInt("dirty_dress");
                no_dress_i= rs.getInt("no_dress");
                iron_i = rs.getInt("iron");
                absent_i = rs.getInt("absent");
                
            }

            sleep.setText(String.valueOf(sleep_i));
            belt.setText(String.valueOf(belt_i));
            bashi.setText(String.valueOf(bashi_i));
            id.setText(String.valueOf(id_i));
            hair.setText(String.valueOf(hair_i));
            shave.setText(String.valueOf(shave_i));
            boot.setText(String.valueOf(boot_i));
            polish.setText(String.valueOf(polish_i));
            civil.setText(String.valueOf(civil_i));
            appulate.setText(String.valueOf(appulate_i));
            nameplate.setText(String.valueOf(nameplate_i));
            shirt.setText(String.valueOf(shirt_i));
            //Set_penaltyController.id.setText(String.valueOf(id));
            
            dayitto.setText(String.valueOf(dayitto_i));
            dirty_dress.setText(String.valueOf(dirty_dress_i));
            no_dress.setText(String.valueOf(no_dress_i));
            iron.setText(String.valueOf(iron_i));
            absent.setText(String.valueOf(absent_i));
        
        
        
        
            

            // show.setText(p);
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void edit_btn_press(ActionEvent event) {
        // label.setText("edit press");
        // enable();
        //label.setText("enabled");
    }

    @FXML
    private void con_rec_press(ActionEvent event) {
        label.setText("Edit pressed");
        enable();
        confirm_btn.setVisible(true);
    }

    @FXML
    private void show_btn_press(ActionEvent event) {
        fetch();
        disable();
        label.setText("value showed");
        con_rec.setVisible(true);

    }

}

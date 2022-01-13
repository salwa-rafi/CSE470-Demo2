/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import com.jfoenix.controls.JFXButton;
import static guardmanagementsystem.GuardManagementSystem.mainstage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class AddPenaltyController implements Initializable {

    String GFID_s;
    String INSPECTOR_GFID_s;
    String ZONE_s;
    String GUARD_AREA_s;
    LocalDate DATE_s;
    String TIME_s;
    String condition;
    String comment;
    StringBuilder final_condition;
    StringBuilder final_comment;
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
    int amount = 0;

    int dayitto_i = 0;
    int dirty_dress_i = 0;
    int no_dress_i = 0;
    int iron_i = 0;
    int absent_i = 0;

    @FXML
    private JFXButton back_btn;
    @FXML
    private TextField INSPECTOR_GFID;
    @FXML
    private TextField ZONE;
    @FXML
    private TextField GUARD_AREA;
    @FXML
    private TextField GFID;
    @FXML
    private DatePicker DATE;
    @FXML
    private TextField TIME;
    @FXML
    private CheckBox c6;
    @FXML
    private CheckBox c8;
    @FXML
    private CheckBox c11;
    @FXML
    private CheckBox c12;
    @FXML
    private CheckBox c13;
    @FXML
    private CheckBox c9;
    @FXML
    private CheckBox c14;
    @FXML
    private CheckBox c10;
    @FXML
    private CheckBox c15;
    @FXML
    private CheckBox c16;
    @FXML
    private CheckBox c17;
    @FXML
    private CheckBox c18;
    @FXML
    private CheckBox c19;
    @FXML
    private CheckBox c20;
    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private CheckBox c4;
    @FXML
    private CheckBox c5;
    @FXML
    private CheckBox c7;
    @FXML
    private CheckBox r21;
    @FXML
    private CheckBox r22;
    @FXML
    private CheckBox r31;
    @FXML
    private CheckBox r32;
    @FXML
    private CheckBox r33;
    @FXML
    private CheckBox r41;
    @FXML
    private CheckBox r42;
    @FXML
    private CheckBox r43;
    @FXML
    private CheckBox r1;
    @FXML
    private CheckBox r2;
    @FXML
    private CheckBox r3;
    @FXML
    private CheckBox r51;
    @FXML
    private CheckBox r52;
    @FXML
    private CheckBox r61;
    @FXML
    private CheckBox r62;
    @FXML
    private CheckBox r53;
    @FXML
    private CheckBox r71;
    @FXML
    private CheckBox r72;
    @FXML
    private Label poshak;
    @FXML
    private Label nostho;
    @FXML
    private Label karon;
    @FXML
    private Label boot;
    @FXML
    private Label id;
    @FXML
    private Label absent;
    @FXML
    private Label plate;
    @FXML
    private JFXButton save;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setcondition() {
        condition = " ";
        if (c1.isSelected()) {
            condition = condition + " , " + c1.getText();
            amount = amount + dayitto_i;
        }
        if (c2.isSelected()) {
            condition = condition + " , " + c2.getText();

        }
        if (c3.isSelected()) {
            condition = condition + " , " + c3.getText();
            amount = amount + sleep_i;
        }
        if (c4.isSelected()) {
            condition = condition + " , " + c4.getText();
        }
        if (c5.isSelected()) {
            condition = condition + " , " + c5.getText();
            amount = amount + no_dress_i;
        }
        if (c6.isSelected()) {
            condition = condition + " , " + c6.getText();
            amount = amount + dirty_dress_i;
        }
        if (c7.isSelected()) {
            condition = condition + " , " + c7.getText();
            amount = amount + shirt_i;
        }
        if (c8.isSelected()) {
            condition = condition + " , " + c8.getText();
            amount = amount + iron_i;
        }
        if (c9.isSelected()) {
            condition = condition + " , " + c9.getText();
            amount = amount + hair_i;
        }
        if (c10.isSelected()) {
            condition = condition + " , " + c10.getText();
            amount = amount + shave_i;
        }
        if (c11.isSelected()) {
            condition = condition + " , " + c11.getText();
            amount = amount + absent_i;
        }
        if (c12.isSelected()) {
            condition = condition + " , " + c12.getText();
            amount = amount + belt_i;
        }
        if (c13.isSelected()) {
            condition = condition + " , " + c13.getText();
            amount = amount + bashi_i;
        }
        if (c14.isSelected()) {
            condition = condition + " , " + c14.getText();
            amount = amount + nameplate_i;
        }
        if (c15.isSelected()) {
            condition = condition + " , " + c15.getText();
            amount = amount + id_i;
        }
        if (c16.isSelected()) {
            condition = condition + " , " + c16.getText();
            amount = amount + boot_i;
        }
        if (c17.isSelected()) {
            condition = condition + " , " + c17.getText();
            amount = amount + polish_i;
        }
        if (c18.isSelected()) {
            condition = condition + " , " + c18.getText();
            amount = amount + civil_i;
        }
        if (c19.isSelected()) {
            condition = condition + " , " + c19.getText();
        }
        if (c20.isSelected()) {
            condition = condition + " , " + c20.getText();
            amount = amount + appulate_i;
        }
        //setfinalcondition();
    }

    public void setfinalcondition() {
        int l = condition.length();
        for (int i = 4; i < l - 1; i++) {
            final_condition.append(condition.charAt(i));
        }
        final_condition.toString();

    }

    public void setfinalcomment() {
        int l = comment.length();
        for (int i = 4; i < l - 1; i++) {
            final_comment.append(comment.charAt(i));
        }
        final_comment.toString();
    }

    public void setcomment() {
        comment = " ";
        if (r1.isSelected()) {
            comment = comment + " , " + poshak.getText();
            comment = comment + " : " + r1.getText();
        }
        if (r2.isSelected()) {
            comment = comment + " , " + poshak.getText();
            comment = comment + " : " + r2.getText();
        }
        if (r3.isSelected()) {
            comment = comment + " , " + poshak.getText();
            comment = comment + " : " + r3.getText();
        }
        if (r21.isSelected()) {
            comment = comment + " , " + nostho.getText();
            comment = comment + " : " + r21.getText();
        }
        if (r22.isSelected()) {
            comment = comment + " , " + nostho.getText();
            comment = comment + " : " + r22.getText();
        }
        if (r31.isSelected()) {
            comment = comment + " , " + karon.getText();
            comment = comment + " : " + r31.getText();
        }
        if (r32.isSelected()) {
            comment = comment + " , " + karon.getText();
            comment = comment + " : " + r32.getText();
        }
        if (r33.isSelected()) {
            comment = comment + " , " + karon.getText();
            comment = comment + " : " + r33.getText();
        }
        if (r41.isSelected()) {
            comment = comment + " , " + boot.getText();
            comment = comment + " : " + r41.getText();
        }
        if (r42.isSelected()) {
            comment = comment + " , " + boot.getText();
            comment = comment + " : " + r42.getText();
        }
        if (r43.isSelected()) {
            comment = comment + " , " + boot.getText();
            comment = comment + " : " + r43.getText();
        }
        if (r51.isSelected()) {
            comment = comment + " , " + id.getText();
            comment = comment + " : " + r51.getText();
        }
        if (r52.isSelected()) {
            comment = comment + " , " + id.getText();
            comment = comment + " : " + r52.getText();
        }
        if (r53.isSelected()) {
            comment = comment + " , " + id.getText();
            comment = comment + " : " + r53.getText();
        }
        if (r61.isSelected()) {
            comment = comment + " , " + absent.getText();
            comment = comment + " : " + r61.getText();
        }
        if (r62.isSelected()) {
            comment = comment + " , " + absent.getText();
            comment = comment + " : " + r62.getText();
        }
        if (r71.isSelected()) {
            comment = comment + " , " + plate.getText();
            comment = comment + " : " + r71.getText();
        }
        if (r72.isSelected()) {
            comment = comment + " , " + plate.getText();
            comment = comment + " : " + r72.getText();
        }
        // setfinalcomment();
    }

    public void process() throws SQLException {
        Connection con = ConnectionManager.getConnection();
        String dc = "SELECT * FROM employee WHERE GFID = '" + GFID_s + "'";
        Statement stmt1;
        try {
            stmt1 = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddPenaltyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pst = con.prepareStatement(dc);
        System.out.println(dc);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            label.setText("No Guard Found");
        } else {
            if (GFID_s.isEmpty()) {
                label.setText("ENTER A GFID");
            } else if (INSPECTOR_GFID_s.isEmpty()) {
                label.setText("ENTER INSPECTOR GFID");
            } else if (DATE_s == null) {
                label.setText("Select a Date");
            } else {

                label.setText("hello");

                String sql = "INSERT INTO `penalty`(`GFID`, `PENALTY_DATE`, `INSPECTOR_GFID`, "
                        + "`ZONE`, `TIME`, `GUARD_LOCATION`, `CONDITION_STATE`, `REMARKS`,`amount`) "
                        + "VALUES "
                        + "('" + GFID_s + "','" + DATE_s + "','" + INSPECTOR_GFID_s + "','" + ZONE_s + "','"
                        + "" + TIME_s + "','" + GUARD_AREA_s + "','" + condition + "','" + comment + "','" + amount + "')";
                String month = DATE_s.getMonth().toString();
                int year = DATE_s.getYear();

                String sql2 = "INSERT INTO `monthly_report`(`MONTH`, `YEAR`,"
                        + " `GFID`, `QUANTITY`, `AMOUNT`, `PAID`) "
                        + "VALUES "
                        + "('" + month + "','" + year + "','" + GFID_s + "','1','" + amount + "','" + amount + "')";

                String sql3 = "UPDATE `monthly_report`\n"
                        + "SET amount=amount+'" + amount + "',\n"
                        + "quantity=quantity+'1',\n"
                        + "paid=paid+'" + amount + "'\n"
                        + "where GFID='" + GFID_s + "'\n"
                        + "and month='" + month + "'\n"
                        + "and year='" + year + "';";

                Statement stmt;
                try {
                    stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(AddPenaltyController.class.getName()).log(Level.SEVERE, null, ex);
                }
                int affected = 0;
                try {
                    stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    affected = stmt.executeUpdate(sql3);
                    label.setText(amount + "trying " + affected);

                    if (affected == 0) {
                        stmt = con.createStatement();
                        stmt.executeUpdate(sql2);
                        label.setText(amount + "catch");
                    }
                } catch (SQLException ex) {
                    // Logger.getLogger(AddPenaltyController.class.getName()).log(Level.SEVERE, null, ex);
                    //stmt = con.createStatement();
                    // stmt.executeUpdate(sql2);
                    // label.setText(amount+"catch");
                }

                con.close();
                label.setText(amount + " taka total fine SAVED SUCCESSFULLY");
                // label.setText(p.toString());
            }
        }
    }

    public void fetch() {

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
                no_dress_i = rs.getInt("no_dress");
                iron_i = rs.getInt("iron");
                absent_i = rs.getInt("absent");

            }

            // show.setText(p);
        } catch (SQLException ex) {
            Logger.getLogger(PenaltyMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setvalue() {
        //back_btn_s=back_btn.getText();
        GFID_s = GFID.getText();
        INSPECTOR_GFID_s = INSPECTOR_GFID.getText();
        ZONE_s = ZONE.getText();
        GUARD_AREA_s = GUARD_AREA.getText();
        DATE_s = DATE.getValue();
        TIME_s = TIME.getText();
        setcondition();
        setcomment();
    }

    @FXML
    private void back_btn_press(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PenaltyMain.fxml"));
        Scene scene = new Scene(root);

        mainstage.setScene(scene);
        mainstage.show();
        mainstage.setResizable(false);
    }

    @FXML
    private void save_press(ActionEvent event) throws SQLException {
        amount = 0;
        fetch();
        setvalue();
        process();
    }

    @FXML
    private void r21press(ActionEvent event) {
    }

    @FXML
    private void r22press(ActionEvent event) {
    }

    @FXML
    private void r31press(ActionEvent event) {
    }

    @FXML
    private void r32(ActionEvent event) {
    }

    @FXML
    private void r33(ActionEvent event) {
    }

    @FXML
    private void r41press(ActionEvent event) {
    }

    @FXML
    private void r42press(ActionEvent event) {
    }

    @FXML
    private void r43press(ActionEvent event) {
    }

    @FXML
    private void r1press(ActionEvent event) {
    }

    @FXML
    private void r2press(ActionEvent event) {
    }

    @FXML
    private void r3press(ActionEvent event) {
    }

    @FXML
    private void r51press(ActionEvent event) {
    }

    @FXML
    private void r52press(ActionEvent event) {
    }

    @FXML
    private void r61press(ActionEvent event) {
    }

    @FXML
    private void r62press(ActionEvent event) {
    }

    @FXML
    private void r53press(ActionEvent event) {
    }

    @FXML
    private void r71press(ActionEvent event) {
    }

    @FXML
    private void r72press(ActionEvent event) {
    }

}

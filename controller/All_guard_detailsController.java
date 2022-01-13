/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guardmanagementsystem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.mysql.jdbc.Connection;
import static guardmanagementsystem.GuardManagementSystem.mainstage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author imtiz
 */
public class All_guard_detailsController implements Initializable {

    byte[] userimage = null;

    @FXML
    private Button add_photo_btn;
    @FXML
    private Button edit_btn;
    @FXML
    private Button update_btn;
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
    //private TextField education;
    @FXML
    private TextField experience;
    @FXML
    private TextField height;
    @FXML
    private Label label;
    @FXML
    private JFXButton back_btn;
    @FXML
    private JFXButton save_btn;
    @FXML
    private JFXDatePicker DOB_TF;
    @FXML
    private JFXDatePicker joining;
    @FXML
    private ImageView image_view;
    @FXML
    private TextField current_address;
    @FXML
    private TextField chest;
    @FXML
    private TextField age;
    @FXML
    private TextField blood;
    @FXML
    private TextField weight;
    @FXML
    private TextField religion;
    @FXML
    private TextField marital;
    @FXML
    private TextField source_name;
    @FXML
    private TextField source_address;
    @FXML
    private TextField source_relation;
    @FXML
    private TextField source_contact;
    @FXML
    private TextField source_occupation;
    @FXML
    private TextField emergency_name_1;
    @FXML
    private TextField emergency_address_1;
    @FXML
    private TextField emergency_relation_1;
    @FXML
    private TextField emergency_contact_1;
    @FXML
    private TextField emergency_occupation_1;
//    @FXML
//    private TextField emergency_name_2;
//    @FXML
//    private TextField emergency_address_2;
//    @FXML
//    private TextField emergency_relation_2;
//    @FXML
//    private TextField emergency_contact_2;
//    @FXML
//    private TextField emergency_occupation_2;
    @FXML
    private TextField edit_gfid;
    int flag = 0;
    String url;
    String GFID_v;
    String NID_v;
    String NAME_v;
    LocalDate DOB_v;
    String FATHER_v;
    String MOTHER_v;
    LocalDate joining_v;
    String designation_v;
    String salary_type_v;
    String remarks_v;
    String ward_v;
    String gram_v;
    String jilla_v;
    String thana_v;
    String posting_v;
    String education_v;
    String experience_v;
    String height_v;
    String contact_v;
    String salary_v;
    String sql;
    String url_v;

    String current_address_v;
    String chest_v;
    String age_v;
    String blood_v;
    String weight_v;
    String religion_v;
    String marital_v;
    String add_v;
    String self_v;
    String relative_v;
    String known_v;
    String source_name_v;
    String source_address_v;
    String source_relation_v;
    String source_contact_v;
    String source_occupation_v;
    String emergency_name_1_v;
    String emergency_address_1_v;
    String emergency_contact_1_v;
    String emergency_occupation_1_v;
    String emergency_relation_1_v;
    String emergency_name_2_v;
    String emergency_address_2_v;
    String emergency_relation_2_v;
    String emergency_contact_2_v;
    String emergency_occupation_2_v;
    String edit_gfid_v;
    FileInputStream fis;
    File file;
    @FXML
    private TextField wife_age;
    @FXML
    private TextField child_name_1;
    @FXML
    private TextField child_name_2;
    @FXML
    private TextField child_name_3;
    @FXML
    private TextField child_relation_1;
    @FXML
    private TextField child_relation_2;
    @FXML
    private TextField child_relation_3;
    @FXML
    private TextField child_age_1;
    @FXML
    private TextField child_age_2;
    @FXML
    private TextField child_age_3;
    @FXML
    private TextField identification;
    @FXML
    private TextField attachment;
    @FXML
    private Label marital_status;
    @FXML
    private Label dob_show;
    @FXML
    private Label joining_show;
    @FXML
    private Label education_show;
    @FXML
    private Label source;
    @FXML
    private ComboBox<String> source_combo;
    @FXML
    private ComboBox<String> marital_combo;
    @FXML
    private ComboBox<String> education_combo;

    String source_v;
    String identification_v;
    String attachment_v;
    String wife_age_v;
    String marital_status_v;
    String child_name_1_v;
    String child_name_2_v;
    String child_name_3_v;
    String child_relation_1_v;
    String child_relation_2_v;
    String child_relation_3_v;
    String child_age_1_v;
    String child_age_2_v;
    String child_age_3_v;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> option1
                = FXCollections.observableArrayList(
                        "5th",
                        "8th",
                        "SSC",
                        "HSC",
                        "Higher",
                        "Other"
                );
        education_combo.setItems(option1);

        ObservableList<String> option2
                = FXCollections.observableArrayList(
                        "Advertisement",
                        "Relative",
                        "Self",
                        "Known"
                );

        source_combo.setItems(option2);

        ObservableList<String> option3
                = FXCollections.observableArrayList(
                        "Married",
                        "Unmarried"
                );

        marital_combo.setItems(option3);

    }

    public void getvalues() {
        GFID_v = GFID_TF.getText();
        NID_v = NID_TF.getText();
        NAME_v = NAME_TF.getText();
        DOB_v = DOB_TF.getValue();
        FATHER_v = FATHER_TF.getText();
        MOTHER_v = MOTHER_TF.getText();
        joining_v = joining.getValue();
        designation_v = designation.getText();
        salary_type_v = salary_type.getText();
        remarks_v = remarks.getText();
        ward_v = ward.getText();
        gram_v = gram.getText();
        jilla_v = jilla.getText();
        thana_v = thana.getText();
        posting_v = posting.getText();
        experience_v = experience.getText();
        height_v = height.getText();
        remarks_v = remarks.getText();
        contact_v = contact.getText();
        salary_v = salary.getText();
        url_v = url;
        current_address_v = current_address.getText();
        chest_v = chest.getText();
        age_v = age.getText();
        blood_v = blood.getText();
        weight_v = weight.getText();
        religion_v = religion.getText();
        marital_v = marital.getText();
        source_name_v = source_name.getText();
        source_address_v = source_address.getText();
        source_relation_v = source_relation.getText();
        source_contact_v = source_contact.getText();
        source_occupation_v = source_occupation.getText();
        emergency_name_1_v = emergency_name_1.getText();
        emergency_address_1_v = emergency_address_1.getText();
        emergency_contact_1_v = emergency_contact_1.getText();
        emergency_occupation_1_v = emergency_occupation_1.getText();
        emergency_relation_1_v = emergency_relation_1.getText();

        education_v = education_combo.getValue();
        source_v = source_combo.getValue();
        identification_v = identification.getText();
        attachment_v = attachment.getText();
        wife_age_v = wife_age.getText();
        marital_status_v = marital_combo.getValue();
        child_name_1_v = child_name_1.getText();
        child_name_2_v = child_name_2.getText();
        child_name_3_v = child_name_3.getText();
        child_relation_1_v = child_relation_1.getText();
        child_relation_2_v = child_relation_2.getText();
        child_relation_3_v = child_relation_3.getText();
        child_age_1_v = child_age_1.getText();
        child_age_2_v = child_age_2.getText();
        child_age_3_v = child_age_3.getText();

    }


    @FXML
    private void add_photo_btn_press(ActionEvent event) throws IOException, SQLException {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        file = fileChooser.showOpenDialog(null);
        BufferedImage bufferedImage = ImageIO.read(file);
        WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
        image_view.setImage(image);
        fis = new FileInputStream(file);
        flag = 1;
    }

    @FXML
    private void back_btn_press(ActionEvent event) {
        try {
            Pane root = FXMLLoader.load(getClass().getResource("AllGuard.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        GuardManagementSystem.mainstage.show();
        GuardManagementSystem.mainstage.setResizable(false);
    }

    @FXML
    private void save_btn_press(ActionEvent event) throws IOException, SQLException {

        getvalues();

        if (GFID_v.isEmpty()) {
            label.setText("Enter a gfid");
        } else if (joining_v == null) {
            label.setText("Select a joining date");
        } else if (DOB_v == null) {
            label.setText("Enter a birthdate");
        } else if (flag == 0) {
            label.setText("Enter an image");
        } else {
            label.setText("Saving Profile");
            Connection con = (Connection) ConnectionManager.getConnection();
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO `employee`(`GFID`, `NID`, "
                        + "`NAME`, `DOB`, `FATHER_NAME`,"
                        + "`MOTHER_NAME`, `SALARY`, `SALARY_TYPE`,"
                        + "`CONTACT`, `HEIGHT`, `EDUCATION`, "
                        + "`EXPERIENCE`, `GRAM_ADDRESS`, `THANA_ADDRESS`, "
                        + "`WARD_ADDRESS`, `JILLA_ADDRESS`, `POSTING`, "
                        + "`REFERENCE`, `REMARKS`, `DESIGNATION`,"
                        + "`JOINING`, `STATUS`, `IMAGE`,`IDENTIFICATION`,`ATTACHMENT`,"
                        + "`MARITAL_STATUS`,`SPOUSE_AGE`,`CHILD_NAME_1`,`CHILD_NAME_2`,`CHILD_NAME_3`,"
                        + "`CHILD_RELATION_1`,`CHILD_RELATION_2`,`CHILD_RELATION_3`,`CHILD_AGE_1`,`CHILD_AGE_2`,`CHILD_AGE_3`, `CURRENT_ADDRESS`,"
                        + "`CHEST`, `AGE`, `BLOOD`, `WEIGHT`, `RELIGION`,"
                        + "`SPOUSE`, `SOURCE`, `SOURCE_NAME`, `SOURCE_ADDRESS`,"
                        + "`SOURCE_CONTACT`, `SOURCE_OCCUPATION`, `SOURCE_RELATION`,"
                        + "`EMERGENCY_NAME_1`, `EMERGENCY_ADDRESS_1`, `EMERGENCY_CONTACT_1`,"
                        + "`EMERGENCY_OCCUPATION_1`, `EMERGENCY_RELATION_1`, `EMERGENCY_NAME_2`,"
                        + "`EMERGENCY_ADDRESS_2`, `EMERGENCY_CONTACT_2`, `EMERGENCY_OCCUPATION_2`,"
                        + "`EMERGENCY_RELATION_2`) VALUES"
                        + "(?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?)\n"
                        + "      ");

                ps.setString(1, GFID_v);
                ps.setString(2, NID_v);
                ps.setString(3, NAME_v);
                ps.setDate(4, java.sql.Date.valueOf(DOB_v));
                ps.setString(5, FATHER_v);
                ps.setString(6, MOTHER_v);
                ps.setString(7, salary_v);
                ps.setString(8, salary_type_v);
                ps.setString(9, contact_v);
                ps.setString(10, height_v);
                ps.setString(11, education_v);
                ps.setString(12, experience_v);
                ps.setString(13, gram_v);
                ps.setString(14, thana_v);
                ps.setString(15, ward_v);
                ps.setString(16, jilla_v);
                ps.setString(17, posting_v);
                ps.setString(18, " ");
                ps.setString(19, remarks_v);
                ps.setString(20, designation_v);
                ps.setDate(21, java.sql.Date.valueOf(joining_v));
                ps.setString(22, "PENDING");
                ps.setBinaryStream(23, fis, (int) file.length());

                ps.setString(24, identification_v);
                ps.setString(25, attachment_v);
                ps.setString(26, marital_status_v);
                ps.setString(27, wife_age_v);
                ps.setString(28, child_name_1_v);
                ps.setString(29, child_name_2_v);
                ps.setString(30, child_name_3_v);
                ps.setString(31, child_relation_1_v);
                ps.setString(32, child_relation_2_v);
                ps.setString(33, child_relation_3_v);
                ps.setString(34, child_age_1_v);
                ps.setString(35, child_age_2_v);
                ps.setString(36, child_age_3_v);

                ps.setString(37, current_address_v);
                ps.setString(38, chest_v);
                ps.setString(39, age_v);
                ps.setString(40, blood_v);
                ps.setString(41, weight_v);
                ps.setString(42, religion_v);
                ps.setString(43, marital_v);
                ps.setString(44, source_v);
                ps.setString(45, source_name_v);
                ps.setString(46, source_address_v);
                ps.setString(47, source_contact_v);
                ps.setString(48, source_occupation_v);
                ps.setString(49, source_relation_v);
                ps.setString(50, emergency_name_1_v);
                ps.setString(51, emergency_address_1_v);
                ps.setString(52, emergency_contact_1_v);
                ps.setString(53, emergency_occupation_1_v);
                ps.setString(54, emergency_relation_1_v);
                ps.setString(55, emergency_name_2_v);
                ps.setString(56, emergency_address_2_v);
                ps.setString(57, emergency_contact_2_v);
                ps.setString(58, emergency_occupation_1_v);
                ps.setString(59, emergency_relation_2_v);
                ps.executeUpdate();
                label.setText("SAVED SUCCESSFULLY");
                System.out.println("Database updated successfully ");
                sleep(2000);
                try {
                    Pane root = FXMLLoader.load(getClass().getResource("AllGuard.fxml"));
                    Scene scene = new Scene(root);
                    GuardManagementSystem.mainstage.setScene(scene);
                } catch (IOException ex) {
                    Logger.getLogger(Admin_mainController.class.getName()).log(Level.SEVERE, null, ex);
                }
                GuardManagementSystem.mainstage.show();
                GuardManagementSystem.mainstage.setResizable(false);

            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
                label.setText("Error!Please Check Again");
            }
            con.close();
        }
    }

    public void setupforedit() {

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
        //education.setDisable(false);
        experience.setDisable(false);
        height.setDisable(false);
        add_photo_btn.setVisible(true);
        save_btn.setVisible(false);
        save_btn.setVisible(false);
        current_address.setDisable(false);
        chest.setDisable(false);
        blood.setDisable(false);
        weight.setDisable(false);
        religion.setDisable(false);
        marital.setDisable(false);
        source_name.setDisable(false);
        source_address.setDisable(false);
        source_relation.setDisable(false);
        source_contact.setDisable(false);
        source_occupation.setDisable(false);
        emergency_name_1.setDisable(false);
        emergency_address_1.setDisable(false);
        emergency_relation_1.setDisable(false);
        emergency_contact_1.setDisable(false);
        emergency_occupation_1.setDisable(false);

        wife_age.setDisable(false);
        child_name_1.setDisable(false);
        child_name_2.setDisable(false);
        child_name_3.setDisable(false);
        child_relation_1.setDisable(false);
        child_relation_2.setDisable(false);
        child_relation_3.setDisable(false);
        child_age_1.setDisable(false);
        child_age_2.setDisable(false);
        child_age_3.setDisable(false);
        identification.setDisable(false);
        attachment.setDisable(false);
        marital_status.setDisable(false);

        //dob_show.setDisable(false);
        //joining_show.setDisable(false);
        //education_show.setDisable(false);
        source_combo.setDisable(false);
        marital_combo.setDisable(false);
        education_combo.setDisable(false);

    }

    @FXML
    private void edit_btn_press(ActionEvent event) throws IOException, SQLException {
        setupforedit();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        edit_gfid_v = edit_gfid.getText();
        String search_field = edit_gfid_v;
        if (edit_gfid_v.isEmpty()) {
            label.setText("ENTER GFID");
        } else {
            con = (Connection) ConnectionManager.getConnection();
            String sql = "SELECT * FROM employee\n"
                    + "WHERE GFID='" + search_field + "'";
            stmt = con.createStatement();
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(All_guard_detailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rs.next()) {
                String gf = rs.getString("GFID");
                GFID_TF.setText(gf);

                String NID = rs.getString("NID");
                NID_TF.setText(NID);

                String NAME = rs.getString("NAME");
                NAME_TF.setText(NAME);

                String FATHER = rs.getString("FATHER_NAME");
                FATHER_TF.setText(FATHER);

                String MOTHER = rs.getString("MOTHER_NAME");
                MOTHER_TF.setText(MOTHER);

                String current_address_v = rs.getString("CURRENT_ADDRESS");
                current_address.setText(current_address_v);

                String chest_v = rs.getString("CHEST");
                chest.setText(chest_v);

                String age_v = rs.getString("AGE");
                age.setText(age_v);

                String blood_v = rs.getString("BLOOD");
                blood.setText(blood_v);

                String weight_v = rs.getString("WEIGHT");
                weight.setText(weight_v);

                String religion_v = rs.getString("RELIGION");
                religion.setText(religion_v);

                String marital_v = rs.getString("SPOUSE");
                marital.setText(marital_v);
                String source_name_v = rs.getString("SOURCE_NAME");
                source_name.setText(source_name_v);
                String source_address_v = rs.getString("SOURCE_ADDRESS");
                source_address.setText(source_address_v);
                String source_relation_v = rs.getString("SOURCE_RELATION");
                source_relation.setText(source_relation_v);
                String source_contact_v = rs.getString("SOURCE_CONTACT");
                source_contact.setText(source_contact_v);
                String source_occupation_v = rs.getString("SOURCE_OCCUPATION");
                source_occupation.setText(source_occupation_v);
                String emergency_name_1_v = rs.getString("EMERGENCY_NAME_1");
                emergency_name_1.setText(emergency_name_1_v);
                String emergency_address_1_v = rs.getString("EMERGENCY_ADDRESS_1");
                emergency_address_1.setText(emergency_address_1_v);
                String emergency_contact_1_v = rs.getString("EMERGENCY_CONTACT_1");
                emergency_contact_1.setText(emergency_contact_1_v);
                String emergency_occupation_1_v = rs.getString("EMERGENCY_OCCUPATION_1");
                emergency_occupation_1.setText(emergency_occupation_1_v);
                String emergency_relation_1_v = rs.getString("EMERGENCY_RELATION_1");
                emergency_relation_1.setText(emergency_relation_1_v);


                String salary_type_v = rs.getString("salary_type");
                salary_type.setText(salary_type_v);

                String remarks_v = rs.getString("remarks");
                remarks.setText(remarks_v);

                String ward_v = rs.getString("ward_address");
                ward.setText(ward_v);

                String gram_v = rs.getString("gram_address");
                gram.setText(gram_v);

                String thana_v = rs.getString("thana_address");
                thana.setText(thana_v);

                String jilla_v = rs.getString("jilla_address");
                jilla.setText(jilla_v);

                String posting_v = rs.getString("posting");
                posting.setText(posting_v);

                //String education_v = rs.getString("education");
                //education.setText(education_v);
                String experience_v = rs.getString("EXPERIENCE");
                experience.setText(experience_v);

                String height_v = rs.getString("height");
                height.setText(height_v);

                String contact_v = rs.getString("contact");
                contact.setText(contact_v);

                String salary_v = rs.getString("salary");
                salary.setText(salary_v);

                String designation_v = rs.getString("designation");
                designation.setText(designation_v);

                identification.setText(rs.getString("identification"));
                attachment.setText(rs.getString("attachment"));
                marital_status.setText(rs.getString("marital_status"));
                wife_age.setText(rs.getString("spouse_age"));
                education_show.setText(rs.getString("education"));
                source.setText(rs.getString("source"));
                dob_show.setText(rs.getString("dob"));
                joining_show.setText(rs.getString("joining"));
                child_name_1.setText(rs.getString("child_name_1"));
                child_name_2.setText(rs.getString("child_name_2"));
                child_name_3.setText(rs.getString("child_name_3"));
                child_relation_1.setText(rs.getString("child_relation_1"));
                child_relation_2.setText(rs.getString("child_relation_2"));
                child_relation_3.setText(rs.getString("child_relation_3"));
                child_age_1.setText(rs.getString("child_age_1"));
                child_age_2.setText(rs.getString("child_age_2"));
                child_age_3.setText(rs.getString("child_age_3"));

                InputStream is = rs.getBinaryStream("IMAGE");
                BufferedImage bimg = ImageIO.read(is);
                WritableImage image = SwingFXUtils.toFXImage(bimg, null);
                image_view.setImage(image);

            }
            con.close();
        }
    }

    public void setupforsearch() {
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
        //education.setDisable(true);
        experience.setDisable(true);
        height.setDisable(true);
        add_photo_btn.setVisible(false);
        save_btn.setVisible(false);
        edit_btn.setVisible(true);
        save_btn.setVisible(false);
        update_btn.setVisible(true);
        current_address.setDisable(true);
        chest.setDisable(true);
        age.setDisable(true);
        blood.setDisable(true);
        weight.setDisable(true);
        religion.setDisable(true);
        source_name.setDisable(true);
        source_address.setDisable(true);
        source_relation.setDisable(true);
        source_contact.setDisable(true);
        source_occupation.setDisable(true);
        emergency_name_1.setDisable(true);
        emergency_address_1.setDisable(true);
        emergency_relation_1.setDisable(true);
        emergency_contact_1.setDisable(true);
        emergency_occupation_1.setDisable(true);

        wife_age.setDisable(true);
        child_name_1.setDisable(true);
        child_name_2.setDisable(true);
        child_name_3.setDisable(true);
        child_relation_1.setDisable(true);
        child_relation_2.setDisable(true);
        child_relation_3.setDisable(true);
        child_age_1.setDisable(true);
        child_age_2.setDisable(true);
        child_age_3.setDisable(true);
        identification.setDisable(true);
        attachment.setDisable(true);
        marital_status.setDisable(true);

        //dob_show.setDisable(true);
        //joining_show.setDisable(true);
        //education_show.setDisable(true);
        source_combo.setDisable(true);
        marital_combo.setDisable(true);
        education_combo.setDisable(true);

    }

    @FXML
    private void update_btn_press(ActionEvent event) throws SQLException {

        getvalues();

        if (GFID_v.isEmpty()) {
            label.setText("Enter a GFID");
        } else if (joining_v == null) {
            label.setText("Re-enter a Joining Date");
        } else if (DOB_v == null) {
            label.setText("Re-enter a Birthdate");
        } else if (flag == 0) {
            label.setText("Re-enter Guard Image");
        } else {
            label.setText("Updating... ");
            Connection con = (Connection) ConnectionManager.getConnection();
            String query = "delete from employee where GFID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, GFID_v);
            preparedStmt.execute();
            PreparedStatement ps = con.prepareStatement("INSERT INTO `employee`(`GFID`, `NID`, "
                    + "`NAME`, `DOB`, `FATHER_NAME`,"
                    + "`MOTHER_NAME`, `SALARY`, `SALARY_TYPE`,"
                    + "`CONTACT`, `HEIGHT`, `EDUCATION`, "
                    + "`EXPERIENCE`, `GRAM_ADDRESS`, `THANA_ADDRESS`, "
                    + "`WARD_ADDRESS`, `JILLA_ADDRESS`, `POSTING`, "
                    + "`REFERENCE`, `REMARKS`, `DESIGNATION`,"
                    + "`JOINING`, `STATUS`, `IMAGE`,`IDENTIFICATION`,`ATTACHMENT`,"
                    + "`MARITAL_STATUS`,`SPOUSE_AGE`,`CHILD_NAME_1`,`CHILD_NAME_2`,`CHILD_NAME_3`,"
                    + "`CHILD_RELATION_1`,`CHILD_RELATION_2`,`CHILD_RELATION_3`,`CHILD_AGE_1`,`CHILD_AGE_2`,`CHILD_AGE_3`, `CURRENT_ADDRESS`,"
                    + "`CHEST`, `AGE`, `BLOOD`, `WEIGHT`, `RELIGION`,"
                    + "`SPOUSE`, `SOURCE`, `SOURCE_NAME`, `SOURCE_ADDRESS`,"
                    + "`SOURCE_CONTACT`, `SOURCE_OCCUPATION`, `SOURCE_RELATION`,"
                    + "`EMERGENCY_NAME_1`, `EMERGENCY_ADDRESS_1`, `EMERGENCY_CONTACT_1`,"
                    + "`EMERGENCY_OCCUPATION_1`, `EMERGENCY_RELATION_1`, ) VALUES"
                    + "(?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?,?,"
                    + "?,?,?,?)\n"
                    + "      ");

            ps.setString(1, GFID_v);
            ps.setString(2, NID_v);
            ps.setString(3, NAME_v);
            ps.setDate(4, java.sql.Date.valueOf(DOB_v));
            ps.setString(5, FATHER_v);
            ps.setString(6, MOTHER_v);
            ps.setString(7, salary_v);
            ps.setString(8, salary_type_v);
            ps.setString(9, contact_v);
            ps.setString(10, height_v);
            ps.setString(11, education_v);
            ps.setString(12, experience_v);
            ps.setString(13, gram_v);
            ps.setString(14, thana_v);
            ps.setString(15, ward_v);
            ps.setString(16, jilla_v);
            ps.setString(17, posting_v);
            ps.setString(18, " ");
            ps.setString(19, remarks_v);
            ps.setString(20, designation_v);
            ps.setDate(21, java.sql.Date.valueOf(joining_v));
            ps.setString(22, "PENDING");
            ps.setBinaryStream(23, fis, (int) file.length());

            ps.setString(24, identification_v);
            ps.setString(25, attachment_v);
            ps.setString(26, marital_status_v);
            ps.setString(27, wife_age_v);
            ps.setString(28, child_name_1_v);
            ps.setString(29, child_name_2_v);
            ps.setString(30, child_name_3_v);
            ps.setString(31, child_relation_1_v);
            ps.setString(32, child_relation_2_v);
            ps.setString(33, child_relation_3_v);
            ps.setString(34, child_age_1_v);
            ps.setString(35, child_age_2_v);
            ps.setString(36, child_age_3_v);

            ps.setString(37, current_address_v);
            ps.setString(38, chest_v);
            ps.setString(39, age_v);
            ps.setString(40, blood_v);
            ps.setString(41, weight_v);
            ps.setString(42, religion_v);
            ps.setString(43, marital_v);
            ps.setString(44, source_v);
            ps.setString(45, source_name_v);
            ps.setString(46, source_address_v);
            ps.setString(47, source_contact_v);
            ps.setString(48, source_occupation_v);
            ps.setString(49, source_relation_v);
            ps.setString(50, emergency_name_1_v);
            ps.setString(51, emergency_address_1_v);
            ps.setString(52, emergency_contact_1_v);
            ps.setString(53, emergency_occupation_1_v);
            ps.setString(54, emergency_relation_1_v);
            ps.executeUpdate();
            label.setText("UPDATED SUCCESSFULLY");
            setupforsearch();
            con.close();
        }
    }

}

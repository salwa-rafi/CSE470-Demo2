package guardmanagementsystem;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

/**
 * FXML Controller class
 */
public class LoginPageController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXButton sign_in;

    public static String username_s;
    public static String pass_s;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//||username_s.equals("guardforce")
    //||pass_s.equals("guardforce8866")
    
    @FXML
    private void sign_in_press(ActionEvent event) throws IOException {
        username_s = username.getText();
        pass_s = pass.getText();
        boolean enter = false;
        if (username_s.equals("admin")) {
            if (pass_s.equals("admin2019")) {
                enter = true;
            }

        }

        if (enter) {
            Parent root = FXMLLoader.load(getClass().getResource("admin_main.fxml"));
            Scene scene = new Scene(root);
            GuardManagementSystem.mainstage.setScene(scene);
            GuardManagementSystem.mainstage.show();
            GuardManagementSystem.mainstage.setTitle("GuardForce Management System");
            GuardManagementSystem.mainstage.setResizable(false);
        }
    }

    @FXML
    private void close_press(ActionEvent event) {

    }

}

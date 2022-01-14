package guardmanagementsystem;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class GuardManagementSystemextends Application {
    
    public static Stage mainstage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root);
        mainstage=stage;
        Image image=new Image(getClass().getResourceAsStream("/Images/Logo.png"));
        stage.getIcons().add(image);
        mainstage.setScene(scene);
        mainstage.show();
        GuardManagementSystem.mainstage.setTitle("GuardForce Management System");
        mainstage.setResizable(false);
    }
    public static void main(String[] args) {
        
        launch(args);
    }
    
}

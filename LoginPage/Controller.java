package LoginPage;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.RotateEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private TextField username, password;
    @FXML
    private Label errorMessage;
    @FXML
    private Circle circle;
    @FXML
    private StackPane parentPane;
    @FXML
    private VBox loadingPane;
    @FXML
    private AnchorPane LoginPane;

    final String USERNAME = "bangi";
    final String PASSWORD = "123";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setStyle("-fx-text-fill: #ffffff");
        password.setStyle("-fx-text-fill: #ffffff");
        LoginPane.setVisible(false);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1.5), circle);
        rotateTransition.setToAngle(360);
        rotateTransition.setCycleCount(6);
        rotateTransition.setRate(2);
        rotateTransition.play();
        rotateTransition.setOnFinished(e -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(800), LoginPane);
            LoginPane.setVisible(true);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
            scaleTransition.setOnFinished(event->parentPane.getChildren().remove(loadingPane));
        });
    }
    public void passValid(ActionEvent actionEvent) throws Exception {
        if(!(username.getText().trim().equals(USERNAME))||!(password.getText().equals(PASSWORD))){
            errorMessage.setVisible(true);
            errorMessage.setText("Invalid Username or Password");
            errorMessage.setTextFill(Color.RED);
        }else{
            errorMessage.setVisible(false);
            Parent root = FXMLLoader.load(getClass().getResource("../MainPage/MainPage.fxml"));
            Stage stage = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void rotateFinish(RotateEvent rotateEvent) {

    }
}

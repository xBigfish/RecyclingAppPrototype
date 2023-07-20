package Me;

import MainPage.Controller1;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MeController implements Initializable {
    @FXML
    public VBox homePane, redeemPane, storePane, mePane;
    @FXML
    public ImageView homeImage, redeemImage, storeImage, meImage;
    @FXML
    public Label homeLabel, redeemLabel, storeLabel, meLabel, pointLabel;
    @FXML
    private StackPane parentPane;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button logoutButton, collectButton;

    private Image image;

    public void mouseEnter(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()==homePane){
            image = new Image(getClass().getResourceAsStream("HomeHover.png"));
            homeImage.setFitWidth(23);
            homeImage.setFitHeight(24);
            homeImage.setImage(image);
            homeLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==redeemPane) {
            redeemImage.setFitWidth(23);
            redeemImage.setFitHeight(24);
            redeemLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==storePane) {
            image = new Image(getClass().getResourceAsStream("ShopHover.png"));
            storeImage.setFitWidth(23);
            storeImage.setFitHeight(24);
            storeImage.setImage(image);
            storeLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==mePane) {
            meImage.setFitWidth(23);
            meImage.setFitHeight(24);
            meLabel.setStyle("-fx-font-size : 9");
        }
    }

    public void mouseExit(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()==homePane) {
            image = new Image(getClass().getResourceAsStream("home.png"));
            homeImage.setFitWidth(27);
            homeImage.setFitHeight(28);
            homeImage.setImage(image);
            homeLabel.setStyle("-fx-font-size : 10");
        }else if(mouseEvent.getSource()==redeemPane) {
            redeemImage.setFitWidth(27);
            redeemImage.setFitHeight(28);
            redeemLabel.setStyle(" -fx-font-size : 10");
        }else if(mouseEvent.getSource()==storePane) {
            image = new Image(getClass().getResourceAsStream("Shop.png"));
            storeImage.setFitWidth(27);
            storeImage.setFitHeight(28);
            storeImage.setImage(image);
            storeLabel.setStyle("-fx-font-size : 10");
        }else if(mouseEvent.getSource()==mePane) {
            meImage.setFitWidth(27);
            meImage.setFitHeight(28);
            meLabel.setStyle("-fx-font-size : 10");
        }
    }
    public void mouseClick(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() == homePane) {
            Parent root = FXMLLoader.load(getClass().getResource("/MainPage/MainPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) (homePane.getScene().getWindow());
            stage.setScene(scene);
        } else if (mouseEvent.getSource() == redeemPane) {
            Parent root = FXMLLoader.load(getClass().getResource("/Redeem/RedeemPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) (redeemPane.getScene().getWindow());
            stage.setScene(scene);
        } else if (mouseEvent.getSource() == storePane) {
            Parent root = FXMLLoader.load(getClass().getResource("/Directory/Directory.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) (storePane.getScene().getWindow());
            stage.setScene(scene);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pointLabel.setText(""+Controller1.scores);
    }

    public void collectPoint(ActionEvent actionEvent) throws IOException{
        Controller1.scores += 5;
        String point = Integer.toString(Controller1.scores);
        FileOutputStream output = new FileOutputStream("file.txt");
        output.write(point.getBytes());
        pointLabel.setText(""+Controller1.scores);
        BoxBlur blur = new BoxBlur(2, 2, 2);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(parentPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        dialogLayout.setPrefWidth(250);
        dialogLayout.setHeading(new Label("Collect successfully\nYour points: " + Controller1.scores));
        dialogLayout.setAlignment(Pos.CENTER);
        JFXButton okButton = new JFXButton("OK");
        dialogLayout.setBody(okButton);
        dialog.setOnDialogClosed(e->pane.setEffect(null));
        okButton.setOnAction(e-> {
            dialog.close();
            collectButton.setDisable(true);
            collectButton.setText("Collected");
        });
        pane.setEffect(blur);
        dialog.show();

    }

    public void logout(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage/sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)(logoutButton.getScene().getWindow());
        stage.setScene(scene);
    }
}


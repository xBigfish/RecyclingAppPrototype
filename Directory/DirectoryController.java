package Directory;

import MainPage.Controller1;
import Redeem.RedeemPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class DirectoryController implements Initializable{

    RedeemPage directory = new RedeemPage();

    @FXML
    public VBox homePane, redeemPane, storePane, mePane;
    @FXML
    public ImageView homeImage, redeemImage, storeImage, meImage, backButton;
    @FXML
    public Label homeLabel, redeemLabel, storeLabel, meLabel, pointLabel;
    public Button bookbutton, fbbutton, fashionbutton, superbutton;

    private Image image;

    public void setPane(VBox homePane, VBox redeemPane, VBox storePane, VBox mePane){
        this.homePane = homePane;
        this.redeemPane = redeemPane;
        this.storePane = storePane;
        this.mePane = mePane;
    }

    public void setImage(ImageView homeImage, ImageView redeemImage, ImageView storeImage, ImageView meImage){
        this.homeImage = homeImage;
        this.redeemImage = redeemImage;
        this.storeImage = storeImage;
        this.meImage = meImage;
    }

    public void setLabel(Label homeLabel, Label redeemLabel, Label storeLabel, Label meLabel){
        this.homeLabel = homeLabel;
        this.redeemLabel = redeemLabel;
        this.storeLabel = storeLabel;
        this.meLabel = meLabel;
    }

    public void mouseClick(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource()==homePane){
            Parent root = FXMLLoader.load(getClass().getResource("/MainPage/MainPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(homePane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==redeemPane){
            Parent root = FXMLLoader.load(getClass().getResource("/Redeem/RedeemPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(redeemPane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==mePane){
            Parent root = FXMLLoader.load(getClass().getResource("/Me/Me.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(mePane.getScene().getWindow());
            stage.setScene(scene);
        }
    }

    public void mouseEnter(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource()==homePane){
            image = new Image(getClass().getResourceAsStream("HomeHover.png"));
            homeImage.setFitWidth(23);
            homeImage.setFitHeight(24);
            homeImage.setImage(image);
            homeLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==redeemPane) {
            image = new Image(getClass().getResourceAsStream("GiftHover.png"));
            redeemImage.setFitWidth(23);
            redeemImage.setFitHeight(24);
            redeemImage.setImage(image);
            redeemLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==storePane) {
            storeImage.setFitWidth(23);
            storeImage.setFitHeight(24);
            storeLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==mePane) {
            image = new Image(getClass().getResourceAsStream("SettingHover.png"));
            meImage.setFitWidth(23);
            meImage.setFitHeight(24);
            meImage.setImage(image);
            meLabel.setStyle("-fx-font-size : 9");
        }
    }

    public void mouseExit(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource()==homePane) {
            image = new Image(getClass().getResourceAsStream("home.png"));
            homeImage.setFitWidth(27);
            homeImage.setFitHeight(28);
            homeImage.setImage(image);
            homeLabel.setStyle("-fx-font-size : 10");
        }else if(mouseEvent.getSource()==redeemPane) {
            image = new Image(getClass().getResourceAsStream("Gift.png"));
            redeemImage.setFitWidth(27);
            redeemImage.setFitHeight(28);
            redeemImage.setImage(image);
            redeemLabel.setStyle(" -fx-font-size : 10");
        }else if(mouseEvent.getSource()==storePane) {
            storeImage.setFitWidth(27);
            storeImage.setFitHeight(28);
            storeLabel.setStyle("-fx-font-size : 10");
        }else if(mouseEvent.getSource()==mePane) {
            image = new Image(getClass().getResourceAsStream("Setting.png"));
            meImage.setFitWidth(27);
            meImage.setFitHeight(28);
            meImage.setImage(image);
            meLabel.setStyle("-fx-font-size : 10");
        }
    }

    public void clickon(ActionEvent actionEvent) throws IOException{
        if(actionEvent.getSource()==bookbutton){
            Parent root = FXMLLoader.load(getClass().getResource("/BookStore/BookStore.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(bookbutton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==fbbutton){
            Parent root = FXMLLoader.load(getClass().getResource("/FandB/FandB.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(fbbutton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==fashionbutton){
            Parent root = FXMLLoader.load(getClass().getResource("/Fashion/Fashion.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(fashionbutton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==superbutton){
            Parent root = FXMLLoader.load(getClass().getResource("/Supermarket/Supermarket.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(superbutton.getScene().getWindow());
            stage.setScene(scene);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pointLabel.setText(Controller1.scores+"");
    }
}


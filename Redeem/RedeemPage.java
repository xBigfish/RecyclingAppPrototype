package Redeem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RedeemPage {
    @FXML
    public VBox homePane, redeemPane, storePane, mePane;
    @FXML
    public ImageView homeImage, redeemImage, storeImage, meImage;
    @FXML
    public Label homeLabel, redeemLabel, storeLabel, meLabel;
    @FXML
    private Button ecoButton, techButton, houseButton, specialButton;

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
            image = new Image(getClass().getResourceAsStream("SettingHover.png"));
            meImage.setFitWidth(23);
            meImage.setFitHeight(24);
            meImage.setImage(image);
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
            image = new Image(getClass().getResourceAsStream("Setting.png"));
            meImage.setFitWidth(27);
            meImage.setFitHeight(28);
            meImage.setImage(image);
            meLabel.setStyle("-fx-font-size : 10");
        }
    }

    public void mouseClick(MouseEvent mouseEvent) throws IOException {
        if(mouseEvent.getSource()==homePane){
            Parent root = FXMLLoader.load(getClass().getResource("/MainPage/MainPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(homePane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==storePane){
            Parent root = FXMLLoader.load(getClass().getResource("/Directory/Directory.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(homePane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==mePane){
            Parent root = FXMLLoader.load(getClass().getResource("/Me/Me.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(mePane.getScene().getWindow());
            stage.setScene(scene);
        }
    }

    public void redeemCat(ActionEvent actionEvent) throws IOException{
        if(actionEvent.getSource()==ecoButton){
            Parent root = FXMLLoader.load(getClass().getResource("/Recycle/Recycle.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(ecoButton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==techButton){
            Parent root = FXMLLoader.load(getClass().getResource("/Technology/Technology.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(techButton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==houseButton){
            Parent root = FXMLLoader.load(getClass().getResource("/Household/Household.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(houseButton.getScene().getWindow());
            stage.setScene(scene);
        }else if(actionEvent.getSource()==specialButton){
            Parent root = FXMLLoader.load(getClass().getResource("/SpecialPrizes/SpecialPrizes.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(specialButton.getScene().getWindow());
            stage.setScene(scene);
        }
    }
}

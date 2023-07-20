package MainPage;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller1 implements Initializable {
    @FXML
    private VBox homePane, redeemPane, storePane, mePane;
    @FXML
    private ImageView homeImage, redeemImage, storeImage, meImage;
    @FXML
    private ImageView qr;
    @FXML
    private Label pointLabel, homeLabel, redeemLabel, storeLabel, meLabel;
    private Image image;
    public static int scores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            File file = new File("file.txt");
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String pointString = reader.readLine();
            scores = Integer.parseInt(pointString);
            pointLabel.setText(""+scores);
        } catch (Exception e) {

        }
    }

    public void showqr(ActionEvent actionEvent) {
        qr.setVisible(true);
    }

    public void mouseExit(MouseEvent mouseEvent) {
        qr.setVisible(false);
    }

    public void enter(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()==homePane){
            homeImage.setFitWidth(23);
            homeImage.setFitHeight(24);
            homeLabel.setStyle("-fx-font-size : 9");
        }else if(mouseEvent.getSource()==redeemPane) {
            image = new Image(getClass().getResourceAsStream("GiftHover.png"));
            redeemImage.setFitWidth(23);
            redeemImage.setFitHeight(24);
            redeemImage.setImage(image);
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

    public void exit(MouseEvent mouseEvent) {
        if(mouseEvent.getSource()==homePane) {
            homeImage.setFitWidth(27);
            homeImage.setFitHeight(28);
            homeLabel.setStyle("-fx-font-size : 10");
        }else if(mouseEvent.getSource()==redeemPane) {
            image = new Image(getClass().getResourceAsStream("Gift.png"));
            redeemImage.setFitWidth(27);
            redeemImage.setFitHeight(28);
            redeemImage.setImage(image);
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
        if(mouseEvent.getSource()==redeemPane){
            Parent root = FXMLLoader.load(getClass().getResource("/Redeem/RedeemPage.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(redeemPane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==storePane){
            Parent root = FXMLLoader.load(getClass().getResource("/Directory/Directory.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(storePane.getScene().getWindow());
            stage.setScene(scene);
        }else if(mouseEvent.getSource()==mePane){
            Parent root = FXMLLoader.load(getClass().getResource("/Me/Me.FXML"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)(mePane.getScene().getWindow());
            stage.setScene(scene);
        }
    }

}

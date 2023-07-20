package BookStore;

import Directory.DirectoryController;
import Recycle.RecycleController;
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

public class BookStoreController implements Initializable{

    DirectoryController bookStore = new DirectoryController();

    @FXML
    public VBox homePane, redeemPane, storePane, mePane;
    @FXML
    public ImageView homeImage, storeImage, meImage, redeemImage, backImage;
    @FXML
    public Label homeLabel, redeemLabel, storeLabel, meLabel;

    private Image image;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookStore.setPane(homePane, redeemPane, storePane, mePane);
        bookStore.setImage(homeImage, redeemImage, storeImage, meImage);
        bookStore.setLabel(homeLabel, redeemLabel, storeLabel, meLabel);
    }

    public void mouseClick(MouseEvent mouseEvent) throws IOException {
        bookStore.mouseClick(mouseEvent);
    }

    public void mouseEnter(MouseEvent mouseEvent) throws IOException {
        bookStore.mouseEnter(mouseEvent);
    }

    public void mouseExit(MouseEvent mouseEvent) throws IOException {
        bookStore.mouseExit(mouseEvent);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Directory/Directory.FXML"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)(homePane.getScene().getWindow());
        stage.setScene(scene);
    }
}
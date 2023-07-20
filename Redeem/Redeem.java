package Redeem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Redeem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RedeemPage.fxml"));
        primaryStage.setTitle("Mall");
        primaryStage.setScene(new Scene(root, 387, 592));
        primaryStage.show();
    }
}

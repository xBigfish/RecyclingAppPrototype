package Recycle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecycleMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Recycle.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 387, 592));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

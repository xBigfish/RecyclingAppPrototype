package MainPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        primaryStage.setTitle("MALL");
        primaryStage.getIcons().add(new Image("C:\\Users\\CheeYan\\IdeaProjects\\Worker\\src\\logo.png"));
        primaryStage.setScene(new Scene(root, 387, 592));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

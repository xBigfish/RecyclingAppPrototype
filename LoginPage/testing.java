package LoginPage;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class testing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));

        System.out.println(x.get());
        System.out.println(y.get());

        x.setValue(10);
        System.out.println(x.get());
        System.out.println(y.get());

        StackPane stackPane = new StackPane();
        primaryStage.setScene(new Scene(stackPane, 300, 275));
        primaryStage.show();
    }
}



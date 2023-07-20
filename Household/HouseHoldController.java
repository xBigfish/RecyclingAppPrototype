package Household;

import MainPage.Controller1;
import Redeem.RedeemPage;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HouseHoldController implements Initializable {

    RedeemPage household = new RedeemPage();

    @FXML
    public VBox homePane, redeemPane, storePane, mePane;
    @FXML
    public ImageView homeImage, redeemImage, storeImage, meImage, backButton;
    @FXML
    public Label homeLabel, redeemLabel, storeLabel, meLabel;
    @FXML
    private Button redeem520, redeem100;
    @FXML
    private StackPane parentPane;
    @FXML
    private AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        household.setPane(homePane, redeemPane, storePane, mePane);
        household.setImage(homeImage, redeemImage, storeImage, meImage);
        household.setLabel(homeLabel, redeemLabel, storeLabel, meLabel);
    }

    public void mouseClick(MouseEvent mouseEvent) throws IOException {
        household.mouseClick(mouseEvent);
    }

    public void mouseEnter(MouseEvent mouseEvent) throws IOException {
        household.mouseEnter(mouseEvent);
    }

    public void mouseExit(MouseEvent mouseEvent) throws IOException {
        household.mouseExit(mouseEvent);
    }

    public void redeem(ActionEvent actionEvent) throws IOException {
        BoxBlur blur = new BoxBlur(2, 2, 2);
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setAlignment(Pos.CENTER);
        dialogLayout.setPrefWidth(250);
        dialogLayout.setHeading(new Label("Do you sure you wanna redeem?"));
        JFXDialog dialog = new JFXDialog(parentPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        HBox hBox = new HBox(30);
        hBox.setAlignment(Pos.CENTER);
        JFXButton yes = new JFXButton("Yes");
        JFXButton no = new JFXButton("No");
        hBox.getChildren().addAll(yes, no);
        dialogLayout.setBody(hBox);
        dialog.setOnDialogClosed(e->pane.setEffect(null));
        yes.setOnAction(e->{
            if(Controller1.scores>=100) {
                try {
                    if(actionEvent.getSource()==redeem100) {
                        Controller1.scores -= 100;
                        String point = Integer.toString(Controller1.scores);
                        FileOutputStream output = new FileOutputStream("file.txt");
                        output.write(point.getBytes());
                        JFXDialogLayout dialogLayout1 = new JFXDialogLayout();
                        JFXDialog dialog1 = new JFXDialog(parentPane, dialogLayout1, JFXDialog.DialogTransition.CENTER);
                        dialogLayout1.setAlignment(Pos.CENTER);
                        dialogLayout1.setPrefWidth(250);
                        dialogLayout1.setHeading(new Label("Redeem Sucessfully\nYour points: " + Controller1.scores));
                        JFXButton ok = new JFXButton("OK");
                        HBox hbox = new HBox(10);
                        hbox.setAlignment(Pos.CENTER);
                        hbox.getChildren().add(ok);
                        dialogLayout1.setBody(hbox);
                        dialog1.setOnDialogClosed(event->dialog.close());
                        ok.setOnAction(event -> {
                            dialog.close();
                            dialog1.close();
                        });
                        dialog1.show();
                    }else if(actionEvent.getSource()==redeem520) {
                        Controller1.scores -= 520;
                        String point = Integer.toString(Controller1.scores);
                        FileOutputStream output = new FileOutputStream("file.txt");
                        output.write(point.getBytes());
                        JFXDialogLayout dialogLayout1 = new JFXDialogLayout();
                        JFXDialog dialog1 = new JFXDialog(parentPane, dialogLayout1, JFXDialog.DialogTransition.CENTER);
                        dialogLayout1.setAlignment(Pos.CENTER);
                        dialogLayout1.setPrefWidth(250);
                        dialogLayout1.setHeading(new Label("Redeem Sucessfully\nYour points: " + Controller1.scores));
                        JFXButton ok = new JFXButton("OK");
                        HBox hbox = new HBox(10);
                        hbox.setAlignment(Pos.CENTER);
                        hbox.getChildren().add(ok);
                        dialogLayout1.setBody(hbox);
                        dialog1.setOnDialogClosed(event->dialog.close());
                        ok.setOnAction(event -> {
                            dialog.close();
                            dialog1.close();
                        });
                        dialog1.show();
                    }
                }catch(IOException ioException){

                }
            }else{
                JFXDialogLayout dialogLayout1 = new JFXDialogLayout();
                dialogLayout1.setAlignment(Pos.CENTER);
                dialogLayout1.setPrefWidth(250);
                dialogLayout1.setHeading(new Label("Insuffient points\nYour points: " + Controller1.scores));
                JFXDialog dialog1 = new JFXDialog(parentPane, dialogLayout1, JFXDialog.DialogTransition.CENTER);
                JFXButton ok = new JFXButton("OK");
                HBox hbox = new HBox(10);
                hbox.setAlignment(Pos.CENTER);
                hbox.getChildren().add(ok);
                dialogLayout1.setBody(hbox);
                dialog1.setOnDialogClosed(event->dialog.close());
                ok.setOnAction(event->{
                    dialog.close();
                    dialog1.close();
                });
                dialog1.show();
            }
        });
        no.setOnAction(e->{
            dialog.close();
        });
        dialog.show();
        pane.setEffect(blur);
    }

    public void back(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Redeem/RedeemPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.setScene(scene);
    }
}


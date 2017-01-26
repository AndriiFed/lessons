

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class JavaFXApp2 extends Application {
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("Init");
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        System.out.printf("Stop");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello JavaFX");
//    primaryStage.setResizable(false);
        primaryStage.setMaxHeight(450.0);
        primaryStage.setMaxWidth(450.0);

        Pane pane = getPane();


        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Confirmation dialog");
                        alert.setContentText("Are you sure?");

                        Optional<ButtonType> buttonType = alert.showAndWait();
                        if (!buttonType.get().equals(ButtonType.OK)) {
                            event.consume();
                        }
                    }
                }
        );
        primaryStage.show();
    }

    private Pane getPane() throws FileNotFoundException {
        GridPane pane = new GridPane();

        Image image = new Image("java_cup_2.png");
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        pane.add(imageView, 0, 0);
        Button button = new Button("Press me!");
        button.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button src = (Button) event.getSource();
                    src.setStyle("-fx-background-color: " + getButtonColor());
                    src.setText(getButtonText());
                }

                private String getButtonText() {
                    List<String> list = Arrays.asList("Do it again", "I like it", "Don't stop", "Enough, plz");
                    return list.get(new Random().nextInt(list.size()));
                }

                private String getButtonColor() {
                    List<String> list = Arrays.asList("#ff00ff", "#00ff00", "#0000ff", "ff0000", "ff1100");
                    return list.get(new Random().nextInt(list.size()));
                }
            }

        );

        pane.add(button, 0, 1);

        Button button2 = new Button("Show dialog");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setHeaderText("Error has been detected");
                dialog.setContentText("Here is error's description");
                dialog.setTitle("Error dialog");

                TextArea textArea = new TextArea();
                textArea.setText("blablabla");
                textArea.setEditable(false);
                textArea.setPadding(new Insets(10));
                textArea.setStyle("-fx-opacity: 0.5");
                System.out.println(textArea);
                dialog.getDialogPane().setExpandableContent(textArea);

                dialog.getDialogPane().setStyle("-fx-background-color: #ff0000");

                dialog.initModality(Modality.NONE);
/*
* .text-input {
*   -fx-background-color: #ff0000;
* }
* */
                dialog.show();
            }
        });

        pane.add(button2, 0, 3);

        return pane;
    }
}

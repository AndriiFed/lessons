import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class JavaFXApp extends Application {
  public static void main(String ... args) {

    //JavaFXApp app = new JavaFXApp();
    //app.l
    launch(args);
  }

  @Override
  public void init() throws Exception {
    System.out.println("Init");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("Close");
    super.stop();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello JavaFX!");
    //primaryStage.setResizable(false);
    primaryStage.setWidth(500);
    primaryStage.setHeight(500);

    Label label = new Label("Label1");
    Label label2 = new Label("Label2");
    Label label3 = new Label("Label3");
    Label label4 = new Label("Label4");
    Label label5 = new Label("Label5");

    Pane pane;

    GridPane gridPane = new GridPane();
    BorderPane borderPane = new BorderPane(label);
    borderPane.setLeft(label2);
    borderPane.setRight(label3);
    borderPane.setTop(label4);
    borderPane.setBottom(label5);
    //BorderPane borderPane = new BorderPane(label, label2, label3, label4, label5);
    borderPane.setPadding(new Insets(10, 10, 10, 10));


/*
    Label[] labels = new Label[5];

    for (int i = 0; i < labels.length; i++) {
      labels[i] = new Label("label # " + i);
    }
*/

    HBox hboxPane = new HBox();
    Button button = new Button("PRESS");
    button.setOnAction(
      new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          Button src = (Button) event.getSource();
          src.setStyle("-fx-background-color: yellow;");
          src.setText("PRESSED");

          event.consume();
        }
      }
    );



    hboxPane.getChildren().add(button);

    Image image = new Image("atm-yellow-box.jpg");
    ImageView imageView = new ImageView(image);
    hboxPane.getChildren().add(imageView);
    //ToggleButton toggleButton = new ToggleButton("Toggle Button");
    //hboxPane.getChildren().add(toggleButton);


    //pane = borderPane;
    pane = hboxPane;
    Scene scene = new Scene(pane, 700, 700);
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}

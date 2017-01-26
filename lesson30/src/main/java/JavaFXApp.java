

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
  public static void main(String ...args) {
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

    Pane pane;

    pane = getBorderPane();
    pane = getHBoxPane();
    pane = getVBoxPane();
    Group group = getGroupedBoxPane();
    pane = getGridPane();
    pane = getFlowPane();
    pane = getTilePane();
    pane = getAnchorPane();


    Scene scene = new Scene(pane, 400, 400);
    //Scene scene = new Scene(group, 400, 400);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private Pane getAnchorPane() throws FileNotFoundException {
    AnchorPane anchorPane = new AnchorPane();
    Pane hBoxPane = getHBoxPane();
    Pane tilePane = getTilePane();
    anchorPane.getChildren().addAll(hBoxPane, tilePane);

    AnchorPane.setBottomAnchor(hBoxPane, 10.0);
    AnchorPane.setTopAnchor(tilePane, 10.0);

    return anchorPane;
  }

  private Pane getTilePane() throws FileNotFoundException {
    TilePane pane = new TilePane();

    Image image = new Image(new FileInputStream("java_cup_2.png"));
    for (int i = 0; i < 10; i++) {
      ImageView imageView = new ImageView(image);

      imageView.setFitHeight(50);
      imageView.setFitWidth(50);

      pane.getChildren().add(imageView);

    }
    return pane;
  }

  private Pane getFlowPane() {
    FlowPane pane = new FlowPane(Orientation.VERTICAL);
    for (int i = 0; i < 5; i++) {
      pane.getChildren().add(new Button("Button_" + i));
    }
    return pane;
  }

  private Pane getGridPane() {
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(10, 10, 10, 10));

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        Label label = new Label("Text(" + i + "," + j + ")");
        GridPane.setMargin(label, new Insets(10));
//        label.setPadding(new Insets(10));
        pane.add(label, i, j);
      }
    }
    return pane;
  }

  private Group getGroupedBoxPane() {
    Group group = new Group();
    group.getChildren().addAll(getHBoxPane(), getVBoxPane());
    return group;
  }

  private Pane getHBoxPane() {
    Label[] labels = new Label[5];
    for (int i = 0; i < labels.length; i++) {
      labels[i] = new Label("Label_" + i);
    }

    HBox pane = new HBox(labels);

    pane.getChildren().add(new Button("I'm a button"));

    return pane;
  }

  private BorderPane getBorderPane() {
    BorderPane pane = new BorderPane();
    pane.setPadding(new Insets(10, 10, 10, 10 ));

    Label label = new Label("I'm just a text");
    Label label1 = new Label("I'm another text");
    Label label2 = new Label("I'm another text");
    Label label3 = new Label("I'm another text");
    Label label4 = new Label("I'm another text");

    pane.setCenter(label);
    pane.setLeft(label1);
    pane.setRight(label2);
    pane.setTop(label3);
    pane.setBottom(label4);

    return pane;
  }

  public Pane getVBoxPane() {
    Label[] labels = new Label[5];
    for (int i = 0; i < labels.length; i++) {
      labels[i] = new Label("Label_" + i);
    }

    VBox pane = new VBox(labels);

    pane.getChildren().add(new Button("I'm a button"));

    return pane;
  }
}

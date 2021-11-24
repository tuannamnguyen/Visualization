package Visualization;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class test extends Application {
    public void start(Stage primaryStage) {
        Rectangle r = new Rectangle();
        r.setWidth(15);
        r.setHeight(18);
        r.setX(400);
        r.setY(600-18);
        r.setFill(Color.RED);
        Pane pane = new Pane();
        pane.getChildren().addAll(r);
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    } 
}
package Visualization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int APP_WIDTH = 1280;
    public static final int APP_HEIGHT = 720;
    public static final int XGAP = 10;
    public static final int BUTTONROW_BOUNDARY = 80;
    public static int NO_OF_ELEMENTS = 30; 

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        RootController.rootController(root);
        
        Scene scene = new Scene(root, APP_WIDTH, APP_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Visualization");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
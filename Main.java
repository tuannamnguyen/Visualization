import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int APP_WIDTH = 600;
    public static final int APP_HEIGHT = 800;
    public static final int XGAP = 10;
    public static final int BUTTONROW_BOUNDARY = 100;
    public static final int NO_OF_ELEMENTS = 40; 

    @Override
    public void start(Stage primaryStage) {
        Pane center = new Pane();
        center.getChildren().addAll(Element.randomize());

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #1c1c1c");
        root.setCenter(center);
        root.setBottom(buttonRow(center));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Visualization");
        primaryStage.show();
    }

    public HBox buttonRow(Pane center) {
        Button sort = new Button("sort");

        Button random = new Button("randomize");
        random.setOnAction(e -> {
            sort.setDisable(false);
            center.getChildren().clear();
            center.getChildren().addAll(Element.randomize());

        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(sort, random);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-background-color: #336699;");

        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
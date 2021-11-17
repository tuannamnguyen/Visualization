import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class RootController {
    public static void rootController(BorderPane root) {
        Pane center = new Pane();
        center.getChildren().addAll(Element.randomize());

        Button sort = new Button("sort");

        Button random = new Button("randomize");
        random.setOnAction(e -> {
            sort.setDisable(false);
            center.getChildren().clear();
            center.getChildren().addAll(Element.randomize());

        });

        HBox buttonRow = new HBox();
        buttonRow.setPadding(new Insets(15, 12, 15, 12));
        buttonRow.setSpacing(10);
        buttonRow.getChildren().addAll(sort, random);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setStyle("-fx-background-color: #336699;");

        root.setStyle("-fx-background-color: #1c1c1c");
        root.setCenter(center);
        root.setBottom(buttonRow);
    }
}

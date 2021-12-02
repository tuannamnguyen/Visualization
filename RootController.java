package Visualization;

import java.util.ArrayList;
import java.util.List;

import Visualization.Sort.BubbleSort;
import Visualization.Sort.InsertionSort;
import Visualization.Sort.SelectionSort;
import Visualization.Sort.Sort;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RootController {
    public static void rootController(BorderPane root) {
        List<Element> list = new ArrayList<>();
        list.addAll(Element.randomize());

        Pane center = new Pane();
        center.getChildren().addAll(list);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Bubble Sort", "Selection Sort", "Insertion Sort");
        choiceBox.getSelectionModel().select(0);

        Button sort = new Button("sort");
        Button random = new Button("randomize");
        Button setNum = new Button("set size");

        setNum.setOnAction(e -> {
            sort.setDisable(true);
            random.setDisable(true);

            Stage stage = new Stage();
            VBox vbox = new VBox();

            TextField input = new TextField();
            input.setPromptText("size");

            Button add = new Button("add");
            add.setOnAction(event -> {
                Main.NO_OF_ELEMENTS = Integer.parseInt(input.getText().trim());
                list.clear();
                list.addAll(Element.randomize());
                center.getChildren().clear();
                center.getChildren().addAll(list);

                sort.setDisable(false);
                random.setDisable(false);
                stage.close();
            });

            vbox.getChildren().addAll(input, add);
            Scene scene = new Scene(vbox, 200, 200);
            stage.setTitle("set size");
            stage.setScene(scene);

            stage.show();
        });

        sort.setOnAction(e -> {
            sort.setDisable(true);
            random.setDisable(true);

            String selection = choiceBox.getSelectionModel().getSelectedItem();

            SequentialTransition st = new SequentialTransition();

            if (selection.equalsIgnoreCase("BUBBLE SORT")) {
                Sort bubbleSort = new BubbleSort();
                st.getChildren().clear();
                st.getChildren().addAll(bubbleSort.sort(list));
                st.play();
            } else if (selection.equalsIgnoreCase("SELECTION SORT")) {
                Sort selectionSort = new SelectionSort();
                st.getChildren().clear();
                st.getChildren().addAll(selectionSort.sort(list));
                st.play();
            } else if (selection.equalsIgnoreCase("INSERTION SORT")) {
                Sort insertionSort = new InsertionSort();
                st.getChildren().clear();
                st.getChildren().addAll(insertionSort.sort(list));
                st.play();
            }

            st.setOnFinished(event -> random.setDisable(false));
        });

        random.setOnAction(e -> {
            sort.setDisable(true);

            list.clear();
            list.addAll(Element.randomize());
            center.getChildren().clear();
            center.getChildren().addAll(list);

            sort.setDisable(false);
        });

        HBox buttonRow = new HBox();
        buttonRow.setPadding(new Insets(15, 12, 15, 12));
        buttonRow.setSpacing(10);
        buttonRow.getChildren().addAll(sort, random, choiceBox, setNum);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setStyle("-fx-background-color: #336699;");

        root.setCenter(center);
        root.setBottom(buttonRow);
    }
}

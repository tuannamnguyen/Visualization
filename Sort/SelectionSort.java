package Visualization.Sort;

import java.util.List;

import Visualization.Element;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class SelectionSort extends Sort {
    public SelectionSort() {
        super();
    }

    private void selectionSort(List<Element> list) {
        Color minColor = Color.GREEN;

        for (int i = 0; i < list.size() - 1; i++) {
            int min_idx = i;
            this.transitions.add(this.changeColor(list.get(i), minColor));

            for (int j = i + 1; j < list.size(); j++) {
                this.transitions.add(this.changeColor(list.get(j), Element.SELECTED));

                if (list.get(j).getValue() < list.get(min_idx).getValue()) {
                    ParallelTransition pt = new ParallelTransition();
                    pt.getChildren().add(this.changeColor(list.get(min_idx), Element.START));

                    min_idx = j;

                    pt.getChildren().add(this.changeColor(list.get(min_idx), minColor));

                    this.transitions.add(pt);
                    continue;
                }

                this.transitions.add(this.changeColor(list.get(j), Element.START));
            }

            this.transitions.add(this.swap(list, i, min_idx));
            this.transitions.add(this.changeColor(list.get(i), Element.SORTED));

        }

        this.transitions.add(this.changeColor(list.get(list.size() - 1), Element.SORTED));
    }

    @Override
    public List<Transition> sort(List<Element> list) {
        selectionSort(list);

        return this.transitions;
    }
}

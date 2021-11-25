package Visualization.Sort;

import java.util.List;

import Visualization.Element;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;

public class BubbleSort extends Sort {
    public BubbleSort() {
        super();
    }

    private void bubbleSort(List<Element> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                ParallelTransition pt = new ParallelTransition();
                pt.getChildren().add(this.changeColor(list.get(j), Element.SELECTED));
                pt.getChildren().add(this.changeColor(list.get(j + 1), Element.SELECTED));
                transitions.add(pt);

                if (list.get(j).getValue() > list.get(j + 1).getValue()) {
                    transitions.add(swap(list, j, j + 1));
                }

                ParallelTransition pt1 = new ParallelTransition();
                pt1.getChildren().add(this.changeColor(list.get(j), Element.START));
                pt1.getChildren().add(this.changeColor(list.get(j + 1), Element.START));
                transitions.add(pt1);
            }

            transitions.add(this.changeColor(list.get(list.size() - i - 1), Element.SORTED));

        }
    }

    @Override
    public List<Transition> sort(List<Element> list) {
        bubbleSort(list);

        return this.transitions;
    }
}

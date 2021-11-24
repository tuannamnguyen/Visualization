package Visualization.Sort;

import java.util.ArrayList;
import java.util.List;

import Visualization.Element;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.util.Duration;

public class BubbleSort extends Sort {
    public BubbleSort() {
        super();
    }

    private void bubbleSort(List<Element> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // TODO add color for animation

                if (list.get(j).getValue() > list.get(j + 1).getValue()) {
                    transitions.add(swap(list, j, j + 1));
                }
            }
        }
    }

    @Override
    public List<Transition> sort(List<Element> list) {
        bubbleSort(list);

        return this.transitions;
    }
}

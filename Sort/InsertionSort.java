package Visualization.Sort;

import java.util.Collections;
import java.util.List;

import Visualization.Element;
import Visualization.Main;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;

public class InsertionSort extends Sort {
    public InsertionSort() {
        super();
    }

    private void insertionSort(List<Element> list) {
        int xRate = Main.APP_WIDTH / Main.NO_OF_ELEMENTS;

        for (int i = 1; i < list.size(); i++) {
            Element key = list.get(i);
            int j = i - 1;

            transitions.add(changeColor(list.get(i), Element.SELECTED));

            transitions.add(key.moveAlongYAxis(Collections.max(list).getValue() + 350));

            

            while (j >= 0 && key.getValue() < list.get(j).getValue()) {
                transitions.add(list.get(j).moveAlongXAxis(xRate));
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);

            transitions.add(key.moveAlongXAxis(xRate * (j + 1 - i)));
            transitions.add(key.moveAlongYAxis(-(Collections.max(list).getValue() + 350)));
            transitions.add(changeColor(key, Element.SORTED));
            transitions.add(changeColor(list.get(j + 1), Element.START));
        }

        for (Element e : list) {
            transitions.add(changeColor(e, Element.SORTED));
        }

    }

    @Override
    public List<Transition> sort(List<Element> list) {
        insertionSort(list);

        return this.transitions;
    }
}

package Visualization.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Visualization.Element;
import Visualization.Main;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;


public abstract class Sort {
    protected List<Transition> transitions;

    public Sort() {
        transitions = new ArrayList<>();
    }

    public ParallelTransition swap(List<Element> list, int i, int j) {
        ParallelTransition pt = new ParallelTransition();

        int xRate = Main.APP_WIDTH / Main.NO_OF_ELEMENTS;
        int numOfElements = j - i;

        pt.getChildren().addAll(list.get(i).moveAlongXAxis(xRate * numOfElements), list.get(j).moveAlongXAxis(-xRate * numOfElements));

        Collections.swap(list, i, j);

        return pt;
    }

    public abstract List<Transition> sort(List<Element> list);
}

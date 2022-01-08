package nam.Visualization.Sort;

import java.util.List;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import nam.Visualization.Element;

public class BubbleSort extends Sort {
    public BubbleSort() {
        super();
    }

    private void bubbleSort(List<Element> list) {
        boolean swapped = false;

        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                ParallelTransition pt = new ParallelTransition();
                pt.getChildren().add(this.changeColor(list.get(j), Element.SELECTED));
                pt.getChildren().add(this.changeColor(list.get(j + 1), Element.SELECTED));
                transitions.add(pt);

                if (list.get(j).getValue() > list.get(j + 1).getValue()) {
                    transitions.add(swap(list, j, j + 1));
                    swapped = true;
                }

                ParallelTransition pt1 = new ParallelTransition();
                pt1.getChildren().add(this.changeColor(list.get(j), Element.START));
                pt1.getChildren().add(this.changeColor(list.get(j + 1), Element.START));
                transitions.add(pt1);
            }

            transitions.add(this.changeColor(list.get(list.size() - i - 1), Element.SORTED));
            if (!swapped) {
                break;
            }
        }

        ParallelTransition pt2 = new ParallelTransition();
        for (Element e : list) {
            pt2.getChildren().add(this.changeColor(e, Element.SORTED));
        }
        transitions.add(pt2);

    }

    @Override
    public List<Transition> sort(List<Element> list) {
        bubbleSort(list);

        return this.transitions;
    }
}

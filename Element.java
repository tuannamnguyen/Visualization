import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Element extends Rectangle {
    private int value;
    public final Color START = Color.AQUAMARINE;
    public final Color SELECTED = Color.GREEN;
    public final Color SORTED = Color.ORANGE;

    public Element(int value) {
        this.value = value;
        this.setFill(START);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TranslateTransition moveAlongXAxis(int x) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(100));
        transition.setByX(x);

        return transition;
    }

    public void setDimensions(int listLength) {
        this.setWidth(Main.APP_WIDTH / listLength - Main.XGAP);
        this.setHeight(((Main.APP_HEIGHT - Main.BUTTONROW_BOUNDARY) / listLength) * this.value);
    }

    public static List<Element> randomize() {
        List<Element> elementList = new ArrayList<>();
        Random ran = new Random();

        for (int i = 0; i < Main.NO_OF_ELEMENTS; i++) {
            Element element = new Element(ran.nextInt(Main.NO_OF_ELEMENTS));
            element.setX(i * (Main.APP_WIDTH / Main.NO_OF_ELEMENTS));
            element.setDimensions(Main.NO_OF_ELEMENTS);
            elementList.add(element);
        }

        return elementList;
    }
}

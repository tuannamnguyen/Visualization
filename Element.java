package Visualization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Element extends Rectangle implements Comparable<Element> {
    private int value;
    private Text textValue;
    public static final Color START = Color.BLUE;
    public static final Color SELECTED = Color.RED;
    public static final Color SORTED = Color.ORANGE;

    public Element(int value) {
        this.value = value;
        this.textValue = new Text(String.valueOf(value));
        this.setFill(START);
    }

    public TranslateTransition moveAlongXAxis(int x) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(100));
        transition.setByX(x);

        return transition;
    }

    public TranslateTransition moveAlongYAxis(int y) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(200));
        transition.setByY(y);

        return transition;
    }

    public void setDimensions(int listLength) {
        this.setWidth(Main.APP_WIDTH / listLength - Main.XGAP);
        this.setHeight(((Main.APP_HEIGHT - Main.BUTTONROW_BOUNDARY - 300) / listLength) * this.value);
    }

    public static List<Element> randomize() {
        List<Element> elementList = new ArrayList<>();
        Random ran = new Random();

        for (int i = 0; i < Main.NO_OF_ELEMENTS; i++) {
            Element element = new Element(ran.nextInt(Main.NO_OF_ELEMENTS - 1) + 1);

            element.setX(i * (Main.APP_WIDTH / Main.NO_OF_ELEMENTS));
            element.setDimensions(Main.NO_OF_ELEMENTS);

            elementList.add(element);
        }

        return elementList;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Element other) {
        return Integer.compare(value, other.value);
    }
}

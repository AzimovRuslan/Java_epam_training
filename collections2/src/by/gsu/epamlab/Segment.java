package by.gsu.epamlab;

import constants.Constants;

import java.util.Objects;

public class Segment implements Comparable<Segment>{
    private String[] elements;
    private int num = 1;
    private int len = 0;

    public Segment(String[] elements) {
        this.elements = elements;
    }

    public void calculationLen() {
        float x1 = Float.parseFloat(elements[Constants.FIRST_ELEMENT]);
        float y1 = Float.parseFloat(elements[Constants.SECOND_ELEMENT]);
        float x2 = Float.parseFloat(elements[Constants.THREE_ELEMENT]);
        float y2 = Float.parseFloat(elements[Constants.FOUR_ELEMENT]);
        len = (int) Math.round(Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))));
    }

    public void increaseNum() {
        num++;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return len + Constants.DELIMITER + num;
    }

    @Override
    public int compareTo(Segment o) {
        return len - o.len;
    }
}

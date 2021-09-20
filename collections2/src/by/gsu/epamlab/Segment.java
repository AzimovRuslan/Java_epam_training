package by.gsu.epamlab;

import constants.Constants;

public class Segment implements Comparable<Segment>{
    private int num = 1;
    private int len = 0;

    public Segment(String[] elements) {
        len = calculationLen(elements);
    }

    private static int calculationLen(String[] elements) {
        double x1 = Double.parseDouble(elements[Constants.FIRST_ELEMENT]);
        double y1 = Double.parseDouble(elements[Constants.SECOND_ELEMENT]);
        double x2 = Double.parseDouble(elements[Constants.THREE_ELEMENT]);
        double y2 = Double.parseDouble(elements[Constants.FOUR_ELEMENT]);
        return (int) Math.round(Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))));
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

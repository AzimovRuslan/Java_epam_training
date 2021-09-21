package by.gsu.epamlab;

import constants.Constants;

public class NumLen implements Comparable<NumLen>{
    private final int len;
    private int num;

    public NumLen(int len) {
        this.len = len;
        num = 1;
    }

    public void increaseNum() {
        num++;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return len + Constants.DELIMITER + num;
    }

    @Override
    public int compareTo(NumLen o) {
        return len - o.len;
    }
}

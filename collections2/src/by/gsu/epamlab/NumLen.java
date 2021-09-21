package by.gsu.epamlab;

import constants.Constants;

public class NumLen {
    private final int len;
    private int num;

    public NumLen(int len) {
        this.len = len;
        num = 1;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return len + Constants.DELIMITER + num;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final NumLen other = (NumLen) obj;
        if (len != other.len)
            return false;
        other.num++;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + len;
        return result;
    }
}

package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.NumField;

public class NonPositiveArgumentException extends IllegalArgumentException {
    private int value;
    private NumField numField;

    public NonPositiveArgumentException(int value, NumField numField) {
        this.value = value;
        this.numField = numField;
    }

    @Override
    public String toString() {
        return Constants.NON_POSITIVE_HEAD + value + numField;
    }
}

package beans;

import constants.Constants;

public class DecimalResult extends Result{
    public DecimalResult() {}

    @Override
    public String toString() {
        return getLogin() + Constants.DELIMITER + getTest() + Constants.DELIMITER + getDate() + Constants.DELIMITER + getStringMark();
    }

    private String getStringMark() {
        return (getMark() / Constants.DENOMINATOR_FOR_MARK) + Constants.POINT + (getMark() % Constants.DENOMINATOR_FOR_MARK);
    }
}

package beans;

import constants.Constants;

public class HalfResult extends Result{
    public HalfResult() {}

    @Override
    public String toString() {
        return getLogin() + Constants.DELIMITER + getTest() + Constants.DELIMITER + getDate() + Constants.DELIMITER + getStringMark();
    }

    private String getStringMark() {
        String mark = String.valueOf(getMark());
        return (mark.charAt(mark.length() - 1) == '5') ? (String.format(Constants.FORMAT_FOR_MARK, getMark() / Constants.DENOMINATOR_FOR_MARK, getMark() % Constants.DENOMINATOR_FOR_MARK)) : String.valueOf((getMark() / Constants.DENOMINATOR_FOR_MARK));
    }
}

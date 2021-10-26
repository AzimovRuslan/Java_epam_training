package beans;

import constants.Constants;
import java.sql.Date;

public class DecimalResult extends Result{
    public DecimalResult(String login, String name, Date date, int mark) {
        super(login, name, date, mark);
    }

    public DecimalResult(String login, String name, String date, String mark) {
        super(login, name, date, mark);
    }

    @Override
    public String toString() {
        return getLogin() + Constants.DELIMITER + getTest() + Constants.DELIMITER + getDate() + Constants.DELIMITER + getStringMark();
    }

    private String getStringMark() {
        return (getMark() / Constants.DENOMINATOR_FOR_MARK) + Constants.POINT + (getMark() % Constants.DENOMINATOR_FOR_MARK);
    }
}

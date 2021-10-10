package beans;

import constants.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result() {
        ;
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + test + Constants.DELIMITER + getStringDate() + Constants.DELIMITER + getStringMark();
    }

    public String getLogin() {
        return login;
    }

    public String getTest() {
        return test;
    }

    public Date getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setDate(String stringDate) {
        try {
            this.date = Constants.GET_DATE_FORMAT.parse(stringDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public void setMark(String stringMark) {
        this.mark = Integer.parseInt(stringMark.replace(Constants.POINT, ""));
    }

    public String getStringDate() {
        return Constants.SET_DATE_FORMAT.format(date);
    }

    public String getStringMark() {
        return (mark / Constants.DENOMINATOR_FOR_MARK) + Constants.POINT + (mark % Constants.DENOMINATOR_FOR_MARK);
    }
}

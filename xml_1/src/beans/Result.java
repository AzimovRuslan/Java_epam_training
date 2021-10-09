package beans;

import by.gsu.epamlab.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT);

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result() {
        this("", "", new Date(0), 0);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + test + Constants.DELIMITER + outDate() + Constants.DELIMITER + outMark();
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) throws ParseException {
        this.date = FORMAT.parse(date);
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String outDate() {
        return FORMAT.format(date);
    }

    public String outMark() {
        return String.format(Constants.MARK_FORMAT, mark / Constants.DENOMINATOR_FOR_MARK, mark % Constants.DENOMINATOR_FOR_MARK);
    }
}

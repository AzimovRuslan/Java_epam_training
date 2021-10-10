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

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT);

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
        String[] splitDate = stringDate.split(Constants.DASH);
        String date = splitDate[Constants.THIRD_ELEMENT] + Constants.POINT + splitDate[Constants.SECOND_ELEMENT] + Constants.POINT + splitDate[Constants.FIRST_ELEMENT];
        try {
            this.date = DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setMark(String stringMark) {
        String[] splitMark = stringMark.split(Constants.SPLIT_POINT);
        String mark = splitMark[Constants.FIRST_ELEMENT] + splitMark[Constants.SECOND_ELEMENT];
        this.mark = Integer.parseInt(mark);
    }

    public String getStringDate() {
        return DATE_FORMAT.format(date);
    }

    public String getStringMark() {
        return (mark / Constants.DENOMINATOR_FOR_MARK) + "." + (mark % Constants.DENOMINATOR_FOR_MARK);
    }
}

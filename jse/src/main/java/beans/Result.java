package beans;

import constants.Constants;

import java.text.ParseException;
import java.util.Date;

public class Result {
    private int idResult = 0;
    private String login;
    private String test;
    private java.sql.Date date;
    private int mark;
    private String strMark;

    public Result(String login, String test, String date, String mark) {
        this.login = login;
        this.test = test;
        this.date = convertDate(date);
        this.mark = convertMark(mark);
        this.strMark = mark;
    }

    public Result() {}

    public String getLogin() {
        return login;
    }

    public String getTest() {
        return test;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = convertDate(date);
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setMark(String mark) {
        this.mark = convertMark(mark);
    }

    public java.sql.Date convertDate(String stringDate) {
        try {
            Date utilStartDate = Constants.IN_DATE_FORMAT.parse(stringDate);
            return new java.sql.Date(utilStartDate.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public int convertMark(String stringMark) {
        return (stringMark.contains(Constants.POINT)) ? (Integer.parseInt(stringMark.replace(Constants.POINT, ""))) : (Integer.parseInt(stringMark + "0"));
    }

    private String getStringMark() {
        return String.valueOf(mark / Constants.DENOMINATOR_FOR_MARK);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + test + Constants.DELIMITER + date + Constants.DELIMITER + getStringMark();
    }
}

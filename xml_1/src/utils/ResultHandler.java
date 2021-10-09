package utils;

import by.gsu.epamlab.Constants;
import beans.Result;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {
    private enum ResultEnum {
        RESULTS,
        STUDENT,
        LOGIN,
        TESTS,
        TEST;
    }

    private List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String login = "";

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(qName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            Result result = new Result();
            result.setLogin(login);
            result.setTest(attributes.getValue(Constants.NAME));
            try {
                String[] splitDate = attributes.getValue(Constants.DATE).split(Constants.DASH);
                String date = splitDate[Constants.THIRD_ELEMENT] + Constants.POINT + splitDate[Constants.SECOND_ELEMENT] + Constants.POINT + splitDate[Constants.FIRST_ELEMENT];
                result.setDate(date);
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
            String[] splitMark = attributes.getValue(Constants.MARK).split(Constants.SPLIT_POINT);
            String mark = splitMark[Constants.FIRST_ELEMENT] + splitMark[Constants.SECOND_ELEMENT];
            result.setMark(Integer.parseInt(mark));
            results.add(new Result(result.getLogin(), result.getTest(), result.getDate(), result.getMark()));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length).trim();
        if(currentEnum == ResultEnum.LOGIN) {
            if (!information.isEmpty()) {
                login = information;
            }
        }
    }
}

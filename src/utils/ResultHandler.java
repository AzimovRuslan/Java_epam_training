package utils;

import by.gsu.epamlab.Constants;
import beans.Result;
import org.w3c.dom.ls.LSOutput;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {
    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String login = "";

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            Result result = new Result();

            result.setLogin(login);
            result.setTest(attributes.getValue(Constants.NAME_IND));
            result.setDate(attributes.getValue(Constants.DATE_IND));
            result.setMark(attributes.getValue(Constants.MARK_IND));

            results.add(new Result(result.getLogin(), result.getTest(), result.getDate(), result.getMark()));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(currentEnum == ResultEnum.LOGIN) {
            String information = new String(ch, start, length).trim();
            if (!information.isEmpty()) {
                login = information;
            }
        }
    }
}

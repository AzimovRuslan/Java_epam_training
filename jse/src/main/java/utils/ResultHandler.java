package utils;

import beans.DecimalResult;
import beans.Result;
import constants.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {
    public ResultHandler() {

    }

    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private ResultEnum currentEnum;
    private String login;

    List<Result> resultList = new ArrayList<>();

    public List<Result> getResultList() {
        return resultList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            DecimalResult result = new DecimalResult();
            result.setLogin(login);
            result.setTest(attributes.getValue(Constants.NAME_IND));
            result.setDate(attributes.getValue(Constants.DATE_IND));
            result.setMark(attributes.getValue(Constants.MARK_IND));
            resultList.add(result);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
        if(currentEnum == ResultEnum.LOGIN) {
            String information = new String(ch, start, length).trim();
            if (!information.isBlank()) {
                login = information;
            }
        }
    }
}

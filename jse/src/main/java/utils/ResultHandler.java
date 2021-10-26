package utils;

import beans.Result;
import constants.Constants;
import factories.ResultFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {
    private ResultFactory factory;

    public ResultHandler(ResultFactory factory) {
        this.factory = factory;
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
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            Result result = factory.getResultFromFactory(login, attributes.getValue(Constants.NAME_IND), attributes.getValue(Constants.DATE_IND), attributes.getValue(Constants.MARK_IND));
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

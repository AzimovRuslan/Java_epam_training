package factories;

import DBInitialization.ResultImplXml;
import beans.DecimalResult;
import beans.Result;
import interfaces.ResultDao;

public class DecimalResultFactory extends ResultFactory{
    @Override
    public Result getResultFromFactory(String login, String test, java.sql.Date date, int mark) {
        return new DecimalResult(login, test, date, mark);
    }

    @Override
    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new DecimalResult(login, test, date, mark);
    }

    @Override
    public ResultDao getResultImplFromFactory(String filename) {
        return new ResultImplXml(filename, this);
    }
}

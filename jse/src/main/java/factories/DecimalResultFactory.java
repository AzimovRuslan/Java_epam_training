package factories;

import DBInitialization.ResultImplXml;
import beans.DecimalResult;
import beans.Result;
import exceptions.SourceException;
import interfaces.ResultDao;
import java.sql.Date;

public class DecimalResultFactory extends ResultFactory{
    @Override
    public Result getResultFromFactory(String login, String test, Date date, int mark) {
        return new DecimalResult(login, test, date, mark);
    }

    @Override
    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new DecimalResult(login, test, date, mark);
    }

    @Override
    public ResultDao getResultImplFromFactory(String filename) throws SourceException {
        return new ResultImplXml(filename, this);
    }
}

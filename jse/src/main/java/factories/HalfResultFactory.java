package factories;

import beans.HalfResult;
import beans.Result;
import exceptions.SourceException;
import interfaces.ResultDao;

import java.sql.Date;

public class HalfResultFactory extends ResultFactory{
    @Override
    public Result getResultFromFactory(String login, String test, Date date, int mark) {
        return new HalfResult(login, test, date, mark);
    }

    @Override
    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new HalfResult(login, test, date, mark);
    }

    @Override
    public ResultDao getResultImplFromFactory(String filename) throws SourceException {
        return super.getResultImplFromFactory(filename);
    }
}

package factories;

import DBInitialization.ResultImplCsv;
import beans.Result;
import interfaces.ResultDao;

import java.sql.Date;

public class HalfResultFactory extends ResultFactory{
    @Override
    public Result getResultFromFactory(String login, String test, Date date, int mark) {
        return new beans.HalfResult(login, test, date, mark);
    }

    @Override
    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new beans.HalfResult(login, test, date, mark);
    }

    @Override
    public ResultDao getResultImplFromFactory(String filename) {
        return new ResultImplCsv(filename, this);
    }
}

package factories;

import DBInitialization.ResultImplCsv;
import beans.Result;
import exceptions.SourceException;
import interfaces.ResultDao;
import java.sql.Date;

public class ResultFactory {
    public Result getResultFromFactory(String login, String test, Date date, int mark){
        return new Result(login, test, date, mark);
    }

    public Result getResultFromFactory(String login, String test, String date, String mark){
        return new Result(login, test, date, mark);
    }

    public ResultDao getResultImplFromFactory(String filename) throws SourceException {
        return new ResultImplCsv(filename, this);
    }
}

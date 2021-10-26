package factories;

import DBInitialization.ResultImplCsv;
import beans.Result;
import interfaces.ResultDao;

public class ResultFactory {
    public Result getResultFromFactory(String login, String test, java.sql.Date date, int mark){
        return new Result(login, test, date, mark);
    }

    public Result getResultFromFactory(String login, String test, String date, String mark){
        return new Result(login, test, date, mark);
    }

    public ResultDao getResultImplFromFactory(String filename) {
        return new ResultImplCsv(filename, this);
    }
}

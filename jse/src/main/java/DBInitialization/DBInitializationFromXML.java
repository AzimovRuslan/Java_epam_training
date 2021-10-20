package DBInitialization;

import beans.Result;

import java.util.List;

public class DBInitializationFromXML{
    public DBInitializationFromXML() {}

    public void dbInitialization(DBInitialize dbInitialize, List<Result> resultList){
        dbInitialize.delete();
        
        for (Result result : resultList) {
            dbInitialize.createTables(result);
        }
    }
}

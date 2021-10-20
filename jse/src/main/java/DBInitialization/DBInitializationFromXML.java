package DBInitialization;

import beans.Result;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class DBInitializationFromXML extends DefaultHandler {
    public DBInitializationFromXML() {}

    public void dbInitialization(DBInitialize dbInitialize, List<Result> resultList){
        dbInitialize.delete();
        for (Result result : resultList) {
            dbInitialize.createTables(result);
        }
    }
}

import constants.Constants;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import DBInitialization.DBConnect;
import DBInitialization.DBInitializationFromXML;
import DBInitialization.DBInitialize;
import utils.RealizationDBWorker;
import utils.ResultHandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Runner2 {
    public static void main(String[] args) {
        try (Connection connection = DBConnect.getCONNECTION()) {
            try{
                XMLReader reader = XMLReaderFactory.createXMLReader();
                ResultHandler handler = new ResultHandler();
                reader.setContentHandler(handler);
                reader.parse(Constants.FILENAME_XML);

                DBInitializationFromXML dbInitializationFromXML = new DBInitializationFromXML();
                dbInitializationFromXML.dbInitialization(new DBInitialize(connection), handler.getResultList());

                RealizationDBWorker realizationDBWorker = new RealizationDBWorker(connection, Constants.FILENAME_XML);
                realizationDBWorker.realization();
            } catch (SAXException e){
                System.err.println(Constants.ERROR_SAX_PARSER + e);
            } catch (IOException e) {
                System.err.println(Constants.ERROR_IO + e);
            }
        } catch (SQLException e) {
            System.err.println(Constants.FAILED_INITIALIZATION_DB);
        }
    }
}

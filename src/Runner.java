import constants.Constants;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import utils.ResultHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Collection;

public class Runner {
    public static void main(String[] args){
        try{
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ResultHandler handler = new ResultHandler();
            reader.setContentHandler(handler);
            reader.parse(Constants.FILENAME);
            printCollection(handler.getResults());
        } catch (SAXException e){
            System.err.println("Error SAX parser" + e);
        } catch (IOException e) {
            System.err.println("Error I/O stream" + e);
        }
    }

    private static <T> void printCollection(Collection<T> collection) {
        for(T result : collection) {
            System.out.println(result);
        }
    }
}

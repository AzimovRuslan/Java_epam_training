import by.gsu.epamlab.Constants;
import beans.Result;
import utils.ResultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Collection;

public class Runner {
    public static void main(String[] args){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ResultHandler handler = new ResultHandler();
            parser.parse(Constants.FILENAME, handler);

            printCollection(handler.getResults());
        } catch (ParserConfigurationException | SAXException | IOException e){
            throw new IllegalArgumentException();
        }
    }

    private static <T> void printCollection(Collection<T> collection) {
        for(T result : collection) {
            System.out.println(result);
        }
    }
}

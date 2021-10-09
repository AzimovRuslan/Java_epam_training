import by.gsu.epamlab.Constants;
import beans.Result;
import utils.ResultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Runner {
    public static void main(String[] args){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ResultHandler handler = new ResultHandler();
            parser.parse(Constants.FILENAME, handler);

            for(Result result : handler.getResults()) {
                System.out.println(result);
            }
        } catch (ParserConfigurationException | SAXException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}

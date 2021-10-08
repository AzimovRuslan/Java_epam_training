import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

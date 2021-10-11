import by.gsu.epamlab.Result;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            List<Result> results = new ArrayList<>();

            parserXML parserXML = new parserXML("student");
            parser.parse(new File("src/results.xml"), parserXML);
    }

    static class parserXML extends DefaultHandler {
        private String el;
        private boolean isEntered;

        public parserXML(String el) {
            this.el = el;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(el)) {
                isEntered = true;
            }
            if(isEntered) {
                System.out.println(String.format("Element <%s> found", qName));
            }
        }
    }
}

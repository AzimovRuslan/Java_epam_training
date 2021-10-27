package DBInitialization;

import beans.Result;
import constants.Constants;
import exceptions.ParseRuntimeException;
import exceptions.SourceException;
import factories.ResultFactory;
import interfaces.ResultDao;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import utils.ResultHandler;

import java.io.IOException;
import java.util.Iterator;

public class ResultImplXml implements ResultDao {
    private String filename;
    private Iterator<Result> iterator;
    private ResultFactory factory;

    public ResultImplXml(String filename, ResultFactory factory) throws SourceException {
        this.factory = factory;
        this.filename = filename;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ResultHandler handler = new ResultHandler(factory);
            reader.setContentHandler(handler);
            reader.parse(filename);
            iterator = handler.getResultList().iterator();
        } catch (SAXException e){
            throw new ParseRuntimeException(Constants.WRONG_DATA_XML);
        } catch (IOException e) {
            throw new SourceException(e.getMessage());
        }
    }
    @Override
    public Result nextResult() {
        return iterator.next();
    }

    @Override
    public boolean hasResult() {
        return iterator.hasNext();
    }

    @Override
    public void close() {
        iterator = null;
    }
}

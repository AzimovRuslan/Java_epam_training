package DBInitialization;

import beans.Result;
import constants.Constants;
import exceptions.SourceException;
import factories.ResultFactory;
import interfaces.ResultDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ResultImplCsv implements ResultDao {
    private Scanner scanner;
    private String filename;
    private ResultFactory factory;

    public ResultImplCsv(String filename, ResultFactory factory) throws SourceException {
        this.filename = filename;

        try {
            scanner = new Scanner(new FileReader(filename));
            this.factory = factory;
        } catch (FileNotFoundException e) {
            throw new SourceException(e.getMessage());
        }
    }

    @Override
    public Result nextResult() {
        String[] elements = scanner.nextLine().split(Constants.DELIMITER);

        return factory.getResultFromFactory(elements[Constants.FIRST_INDEX], elements[Constants.SECOND_INDEX], elements[Constants.THIRD_INDEX], elements[Constants.FOUR_INDEX]);
    }

    @Override
    public boolean hasResult() {
        return scanner.hasNextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}

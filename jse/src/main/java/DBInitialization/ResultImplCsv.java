package DBInitialization;

import beans.Result;
import constants.Constants;
import factories.ResultFactory;
import interfaces.ResultDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ResultImplCsv implements ResultDao {
    private Scanner scanner;
    private String filename;
    private ResultFactory factory;

    public ResultImplCsv(String filename, ResultFactory factory) {
        this.filename = filename;

        try {
            scanner = new Scanner(new FileReader(filename));
            this.factory = factory;
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    @Override
    public Result nextResult() {
        String[] elements = scanner.nextLine().split(Constants.DELIMITER);

        return factory.getResultFromFactory(elements[Constants.FIRST_ELEMENT], elements[Constants.SECOND_ELEMENT], elements[Constants.THIRD_ELEMENT], elements[Constants.FOUR_ELEMENT]);
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

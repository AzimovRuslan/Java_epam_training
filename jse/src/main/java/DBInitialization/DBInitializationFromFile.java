package DBInitialization;

import beans.Result;
import constants.Constants;

import java.io.*;
import java.util.Scanner;

public class DBInitializationFromFile {

    public DBInitializationFromFile() {}

    public void dbInitialization(String filename, DBInitialize dbInitialize) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            dbInitialize.delete();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(Constants.DELIMITER);
                Result result = new Result(line[Constants.FIRST_INDEX], line[Constants.SECOND_INDEX], line[Constants.THIRD_INDEX], line[Constants.FOUR_INDEX]);

                dbInitialize.createTables(result);
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }
}

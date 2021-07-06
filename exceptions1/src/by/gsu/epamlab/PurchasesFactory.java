package by.gsu.epamlab;

import by.gsu.epamlab.exceptions.*;

public class PurchasesFactory {
    static Purchase getPurchase(String line) throws CsvLineException {
        String[] str = line.split(Constants.DELIMITER);
        int len = str.length;
        String name;
        Byn price;
        int number = 0;

        try {
            name = str[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CsvLineException(Constants.WRONG_AMOUNT_ARGUMENTS);
        }

        if (len > 4 || len < 3) {
            throw new CsvLineException(Constants.WRONG_AMOUNT_ARGUMENTS);
        }

        if (name.length() == 0) {
            throw new CsvLineException(Constants.EMPTY_NAME);
        }

        try {
            price = new Byn(Integer.parseInt(str[1]));
        } catch (NumberFormatException e) {
            throw new CsvLineException(Constants.INCORRECT_NUMBER_FOR_PRICE);
        }

        try {
            number = Integer.parseInt(str[2]);
        } catch (NumberFormatException e) {
            throw new CsvLineException(Constants.INCORRECT_NUMBER_FOR_NUMBER);
        }

        if (len == 3) {
            return new Purchase(name, price, number);
        } else {
            Byn discount;
            try {
                discount = new Byn(Integer.parseInt(str[3]));
            } catch (NumberFormatException e) {
                throw new CsvLineException(Constants.INCORRECT_NUMBER_FOR_DISCOUNT);
            }
            return new PriceDiscountPurchase(name, price, number, discount);
        }
    }
}

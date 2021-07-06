package by.gsu.epamlab;

import by.gsu.epamlab.exceptions.*;

public class PurchasesFactory {
    static Purchase getPurchase(String line) throws CsvLineException {
        String[] str = line.split(Constants.DELIMITER);
        int len = str.length;
        String name;
        Byn price;
        int number = 0;

        if (len > Constants.PRICE_DISCOUNT_PURCHASE_COUNT || len < Constants.PURCHASE_COUNT) {
            throw new CsvLineException(Constants.WRONG_NUMBER_ELEMENTS);
        }

        try {
            name = str[0];
            price = new Byn(Integer.parseInt(str[1]));
            number = Integer.parseInt(str[2]);

            if (name.length() == 0) {
                throw new CsvLineException(Constants.EMPTY_NAME);
            }

            if (len == 3) {
                return new Purchase(name, price, number);
            } else {
                Byn discount;
                try {
                    discount = new Byn(Integer.parseInt(str[3]));
                } catch (NumberFormatException e) {
                    throw new CsvLineException(Constants.WRONG_NUMBER_ARGUMENTS);
                }
                return new PriceDiscountPurchase(name, price, number, discount);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new CsvLineException(Constants.INCORRECT_ARGUMENT);
        }
    }
}

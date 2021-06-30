package by.gsu.epamlab;

import Exceptions.EmptyArgumentException;
import Exceptions.IncorrectNumberException;
import Exceptions.NonPositiveNumberException;
import Exceptions.WrongAmountArgumentsException;

public class PurchasesFactory {
    static Purchase getPurchase(String line) throws WrongAmountArgumentsException, IncorrectNumberException, NonPositiveNumberException, EmptyArgumentException {
        String[] str = line.split(Constants.DELIMITER);
        int len = str.length;
        String name;
        Byn price;
        int number = 0;

        try {
            name = str[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new WrongAmountArgumentsException(line + Constants.ARROW + Constants.WRONG_AMOUNT_ARGUMENTS);
        }

        if (len > 4 || len < 3) {
            throw new WrongAmountArgumentsException(line + Constants.ARROW + Constants.WRONG_AMOUNT_ARGUMENTS);
        }

        if (name.length() == 0) {
            throw new EmptyArgumentException(line + Constants.ARROW + Constants.EMPTY_NAME);
        }

        try {
            price = new Byn(Integer.parseInt(str[1]));
        } catch (NumberFormatException e) {
            throw new IncorrectNumberException(line + Constants.ARROW + Constants.INCORRECT_NUMBER_FOR_PRICE);
        }

        if (price.getKopecks() <= 0) {
            throw new NonPositiveNumberException(line + Constants.ARROW + Constants.NON_POSITIVE_HEAD + price + Constants.NON_POSITIVE_PRICE_TAIL);
        }

        try {
            number = Integer.parseInt(str[2]);
        } catch (NumberFormatException e) {
            throw new IncorrectNumberException(line + Constants.ARROW + Constants.INCORRECT_NUMBER_FOR_NUMBER);
        }

        if (number <= 0) {
            throw new NonPositiveNumberException(line + Constants.ARROW + Constants.NON_POSITIVE_HEAD + number + Constants.NON_POSITIVE_NUMBER_TAIL);
        }

        if (len == 3) {
            return new Purchase(name, price, number);
        } else {
            Byn discount;
            try {
                discount = new Byn(Integer.parseInt(str[3]));
            } catch (NumberFormatException e) {
                throw new IncorrectNumberException(line + Constants.ARROW + Constants.INCORRECT_NUMBER_FOR_DISCOUNT);
            }

            if (discount.getKopecks() <= 0 || discount.getKopecks() >= 100) {
                throw new NonPositiveNumberException(line + Constants.ARROW + Constants.NON_POSITIVE_HEAD + discount + Constants.NON_POSITIVE_DISCOUNT_TAIL);
            }

            return new PriceDiscountPurchase(name, price, number, discount);
        }
    }
}

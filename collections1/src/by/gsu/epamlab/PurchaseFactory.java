package by.gsu.epamlab;

public class PurchaseFactory {
    public static Purchase getPurchase(String line){
        String[] str = line.split(Constants.DELIMITER);
        int len = str.length;
        String name;
        Byn price;
        int number = 0;

        name = str[Constants.FIRST_ELEMENT];
        price = new Byn(Integer.parseInt(str[Constants.SECOND_ELEMENT]));
        number = Integer.parseInt(str[Constants.THIRD_ELEMENT]);

        if (len == 3) {
            return new Purchase(name, price, number);
        } else {
            Byn discount;

            discount = new Byn(Integer.parseInt(str[3]));

            return new PricePurchase(name, price, number, discount);
        }
    }
}

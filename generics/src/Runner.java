import by.gsu.asoilab.*;

public class Runner {
    public static void main(String[] args) {
        Product milk = new Product("milk", new Byn(170));
        Purchase<Product, Integer> p1 = new Purchase<>(milk, 20);
        PurchaseUtils<Product, Integer> pu1 = new PurchaseUtils<>(p1);
        pu1.printPurchase();
        pu1.printCost();

        Product sugar = new Product("sugar", new Byn(300));
        Purchase<Product, Double> p2 = new Purchase<>(sugar, 12.5);
        PurchaseUtils<Product, Double> pu2 = new PurchaseUtils<>(p2);
        pu2.printCost();

        pu2.printCostDiff(p1);

        DiscountProduct sugar1 = new DiscountProduct("sugar", new Byn(280), new Byn(10));
        Purchase<DiscountProduct, Integer> p3 = new Purchase<>(sugar1, 60);
        PurchaseUtils<DiscountProduct, Integer> pu3 = new PurchaseUtils<>(p3);
        pu3.printCost();

        Service subscription = new Service("subscription", new Byn(7560), 5);
        PurchaseUtils<Service, Double> pu4 = new PurchaseUtils<>(new Purchase<>(subscription, 2.25));
        Service service = pu4.getPurchase().getItem();
        System.out.println(service);
        pu4.printCost();

        pu2.printSameCost(p1, p3, pu4.getPurchase());
    }
}

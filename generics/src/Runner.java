import by.gsu.asoilab.*;
import by.gsu.asoilab.interfaces.Priceable;

public class Runner {
    public static void main(String[] args) {
        Product milk = new Product("milk", new Byn(170));
        Purchase p1 = new Purchase(milk, 20);
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();

        Product sugar = new Product("sugar", new Byn(300));
        Purchase p2 = new Purchase(sugar, 12.5);
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printCost();

        pu2.printCostDiff(p1);

        DiscountProduct sugar1 = new DiscountProduct("sugar", new Byn(280), new Byn(10));
        Purchase p3 = new Purchase(sugar1, 60);
        PurchaseUtils pu3 = new PurchaseUtils(p3);
        pu3.printCost();

        Service subscription = new Service("subscription", new Byn(7560), 5);
        Purchase<Service, Double> purchase = new Purchase<>(subscription, 2.25);
        PurchaseUtils<Service, Double> pu4 = new PurchaseUtils<>(purchase);
        Service service = pu4.getPurchase().getItem();
        System.out.println(service);
        pu4.printCost();

        pu2.printSameCost(p1, p3, pu4.getPurchase());
    }
}

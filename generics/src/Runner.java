import by.gsu.asoilab.*;

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
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(subscription, 2.25));
        Purchase purchase = pu4.getPurchase();
        System.out.println(purchase);
        pu4.printCost();

        Purchase[] purchases = {p1, p3, purchase};
        pu2.printSameCost(purchases);
    }
}

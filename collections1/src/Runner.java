import by.gsu.epamlab.*;
import by.gsu.epamlab.interfaces.EntryChecker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        final String FILENAME = "src/in.csv";
        try(Scanner sc = new Scanner(new FileReader(FILENAME))) {
            Map<Purchase, WeekDay> firstPurchasesMap = new HashMap<>();
            Map<Purchase, WeekDay> lastPurchasesMap = new HashMap<>();
            Map<WeekDay, List<Purchase>> dayPurchasesMap = new EnumMap<>(WeekDay.class);
            List<PricePurchase> priceDiscountPurchases = new ArrayList<>();

            while (sc.hasNextLine()) {
                Purchase purchase = PurchaseFactory.getPurchase(sc.nextLine());
                WeekDay weekday = WeekDay.valueOf(sc.nextLine());

                lastPurchasesMap.put(purchase, weekday);

                if (!firstPurchasesMap.containsKey(purchase)) {
                    firstPurchasesMap.put(purchase, weekday);
                }

                List<Purchase> l = dayPurchasesMap.get(weekday);
                if (l == null) {
                    dayPurchasesMap.put(weekday, l = new ArrayList<Purchase>());
                }
                l.add(purchase);

                if (purchase instanceof PricePurchase) {
                    priceDiscountPurchases.add((PricePurchase) purchase);
                }
            }
            //2
            printMap(lastPurchasesMap, Constants.LAST_PURCHASE_MAP);

            //4
            printMap(firstPurchasesMap, Constants.FIRST_PURCHASE_MAP);

            //5
            Purchase elementToSearch = new Purchase("bread", new Byn(155), 0);
            findAndShow(findWeekDayForPurchases(firstPurchasesMap), elementToSearch, Constants.THE_LAST_WEEKDAY_FOR_BREAD + " 1.55");
            findAndShow(findWeekDayForPurchases(lastPurchasesMap), elementToSearch, Constants.THE_FIRST_WEEKDAY_FOR_BREAD + " 1.55");

            //6
            findAndShow(findWeekDayForPurchases(lastPurchasesMap), new Purchase("bread", new Byn(170), 0), Constants.THE_FIRST_WEEKDAY_FOR_BREAD + " 1.70");

            //7
            removeEntries(firstPurchasesMap, new EntryChecker<Purchase, WeekDay>() {

                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return Constants.MEAT.equals(entry.getKey().getName());
                }
            });

            //8
            removeEntries(lastPurchasesMap, new EntryChecker<Purchase, WeekDay>() {

                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return WeekDay.FRIDAY == entry.getValue();
                }
            });

            removeEntries(dayPurchasesMap, new EntryChecker<WeekDay, List<Purchase>>() {
                @Override
                public boolean check(Map.Entry<WeekDay, List<Purchase>> entry) {
                    String milk = "";

                    for (int i = 0; i < entry.getValue().size(); i++) {
                        String name = entry.getValue().get(i).getName();
                        if (Constants.MILK.equals(name)) {
                            milk = name;
                        }
                    }

                    return Constants.MILK.equals(milk);
                }
            });

            //9
            printMap(firstPurchasesMap, Constants.FIRST_PURCHASE_MAP);
            printMap(lastPurchasesMap, Constants.LAST_PURCHASE_MAP);

            //11
            System.out.println(Constants.TOTAL_COST + getTotalCost(priceDiscountPurchases) + Constants.BYN);

            //13
            printMap(dayPurchasesMap, Constants.DAY_PURCHASE_MAP);

            //14
            for(Map.Entry<WeekDay, List<Purchase>> entry : dayPurchasesMap.entrySet()) {
                System.out.println(Constants.TOTAL_COST_FOR_DAY + entry.getKey() + Constants.MAP_DELIMITER + getTotalCost(entry.getValue()));
            }

            //15
            findAndShow(dayPurchasesMap, WeekDay.MONDAY, Constants.ALL_PURCHASES_ON_MONDAY);
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static<K, V> void printMap(Map<K, V> map, String comment) {
        if (map.size() > 0) {
            System.out.println(comment);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.println(entry.getKey() + Constants.MAP_DELIMITER + entry.getValue());
            }
        } else {
            System.out.println(Constants.EMPTY_MAP);
        }
    }

    private static Map<Purchase, WeekDay> findWeekDayForPurchases(Map<Purchase, WeekDay> map) {
        Map<Purchase, WeekDay> additionalMap = new HashMap<>();
        for (Map.Entry<Purchase, WeekDay> entry : map.entrySet()) {
            if (entry.getValue() == WeekDay.MONDAY || entry.getValue() == WeekDay.TUESDAY || entry.getValue() == WeekDay.WEDNESDAY || entry.getValue() == WeekDay.THURSDAY || entry.getValue() == WeekDay.FRIDAY) {
                additionalMap.put(entry.getKey(), entry.getValue());
            }
        }
        return additionalMap;
    }

    private static <K, V> void findAndShow(Map<K, V> map, K searchKey, String header) {
        V key = map.get(searchKey);
        if (key != null) {
            System.out.println(header + Constants.MAP_DELIMITER + key);
        } else {
            System.out.println(header + Constants.MAP_DELIMITER + Constants.ELEMENT_NOT_FOUND);
        }
    }

    private static<K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> checker) {
        for(Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            if (checker.check(iterator.next())) {
                iterator.remove();
            }
        }
    }

    private static Byn getTotalCost(List<? extends Purchase> purchases) {
        Byn cost = new Byn(0);

        for (Purchase purchase : purchases) {
            cost = cost.add(purchase.getCost());
        }
        return cost;
    }
}

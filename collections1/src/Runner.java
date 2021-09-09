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

                if (!dayPurchasesMap.containsKey(weekday)) {
                    dayPurchasesMap.put(weekday, new ArrayList<>());
                }
                dayPurchasesMap.get(weekday).add(purchase);

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
            findAndShow(findWeekDayForPurchases(firstPurchasesMap), elementToSearch, "the first weekday for bread with price 1.55");
            findAndShow(findWeekDayForPurchases(lastPurchasesMap), elementToSearch, "the first weekday for bread with price 1.55");

            //6
            findAndShow(findWeekDayForPurchases(lastPurchasesMap), new Purchase("bread", new Byn(170), 0), "the first weekday for bread with price 1.70");

            //7
            removeEntries(firstPurchasesMap, new EntryChecker<Purchase, WeekDay>() {

                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getKey().getName().equals(Constants.MEAT);
                }
            });

            //8
            removeEntries(lastPurchasesMap, new EntryChecker<Purchase, WeekDay>() {

                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getValue().equals(WeekDay.FRIDAY);
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
            printCostForWeekdayByEnumMap(dayPurchasesMap);

            //15
            findAndShow(dayPurchasesMap, WeekDay.MONDAY, "all purchases on MONDAY");
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
        Map<K, V> additionalMap = new HashMap<>();
        if (map.size() > 0) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (entry.getKey().equals(searchKey)) {
                    additionalMap.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            System.out.println(Constants.ELEMENT_NOT_FOUND);
        }

        if (additionalMap.size() > 0) {
            printMap(additionalMap, header);
        } else {
            System.out.println(header + Constants.CARRYOVER + Constants.ELEMENT_NOT_FOUND);
        }
    }

    private static List<Purchase> elementForDelete(Map<Purchase, WeekDay> map, WeekDay weekDay) {
        List<Purchase> purchases = new ArrayList<>();
        for(Map.Entry<Purchase, WeekDay> entry : map.entrySet()) {
            if (entry.getValue().equals(weekDay)) {
                purchases.add(entry.getKey());
            }
        }
        return purchases;
    }

    private static<K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> checker) {
        for(Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<K, V> entry = iterator.next();
            if (checker.check(entry)) {
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

    private static void printCostForWeekdayByEnumMap(Map<WeekDay, List<Purchase>> map) {
        for(Map.Entry<WeekDay, List<Purchase>> entry : map.entrySet()) {
            if (entry.getKey() == WeekDay.MONDAY || entry.getKey() == WeekDay.TUESDAY || entry.getKey() == WeekDay.WEDNESDAY || entry.getKey() == WeekDay.THURSDAY || entry.getKey() == WeekDay.FRIDAY) {
                System.out.println(Constants.TOTAL_COST_FOR_DAY + entry.getKey() + Constants.SPACE + getTotalCost(entry.getValue()) + Constants.BYN);
            }
        }
    }
}

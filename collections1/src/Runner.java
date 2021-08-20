import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME))) {
            Map<Purchase, WeekDay> firstMap = new HashMap<>();
            Map<Purchase, WeekDay> lastMap = new HashMap<>();
            Map<WeekDay, List<Purchase>> enumeratedMap = new EnumMap<>(WeekDay.class);
            List<PricePurchase> purchases = new ArrayList<>();

            while (sc.hasNextLine()) {
                Purchase purchase = PurchaseFactory.getPurchase(sc.nextLine());
                WeekDay weekday = WeekDay.valueOf(sc.nextLine());

                lastMap.put(purchase, weekday);

                if (!firstMap.containsKey(purchase)) {
                    firstMap.put(purchase, weekday);
                }

                if (purchase instanceof PricePurchase) {
                    purchases.add((PricePurchase) purchase);
                }

                if (!enumeratedMap.containsKey(weekday)) {
                    enumeratedMap.put(weekday, new ArrayList<>());
                }
                enumeratedMap.get(weekday).add(purchase);
            }
            //2
            printMap(firstMap);

            //4
            printMap(lastMap);

            //5
            Purchase elementToSearch = new Purchase("bread", new Byn(155), 0);
            findWeekdayForPurchase(findElement(firstMap, elementToSearch));
            findWeekdayForPurchase(findElement(lastMap, elementToSearch));

            //6
            findWeekdayForPurchase(findElement(lastMap, new Purchase("bread", new Byn(170), 0)));

            //7
            deleteElementByKey(firstMap, new Purchase("meat", new Byn(0), 0));

            //8
            deleteElementByValue(lastMap, elementForDelete(lastMap, WeekDay.FRIDAY));

            //9
            printMap(firstMap);
            printMap(lastMap);

            //11
            System.out.println(Constants.TOTAL_COST + totalCost(purchases) + Constants.BYN);

            //13
            printMap(enumeratedMap);

            //14
            printCostForWeekdayByEnumMap(enumeratedMap);

            //15
            System.out.println(findElement(enumeratedMap, WeekDay.MONDAY));

        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static void findWeekdayForPurchase(Map<Purchase, WeekDay> map) {
        if (map.size() > 0) {
            for (Map.Entry<Purchase, WeekDay> entry : map.entrySet()) {
                if (entry.getValue() == WeekDay.MONDAY || entry.getValue() == WeekDay.TUESDAY || entry.getValue() == WeekDay.WEDNESDAY || entry.getValue() == WeekDay.THURSDAY || entry.getValue() == WeekDay.FRIDAY) {
                    System.out.println(entry.getKey() + Constants.MAP_DELIMITER + entry.getValue());
                } else {
                    System.out.println(Constants.ELEMENT_NOT_FOUND);
                }
            }
        } else {
            System.out.println(Constants.ELEMENT_NOT_FOUND);
        }
    }

    private static<K, V> void printMap(Map<K, V> map) {
        if (map.size() > 0) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.println(entry.getKey() + Constants.MAP_DELIMITER + entry.getValue());
            }
        } else {
            System.out.println(Constants.EMPTY_MAP);
        }
    }

    private static <K, V, T> Map<K, V> findElement(Map<K, V> map, T obj) {
        Map<K, V> additionalMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey().equals(obj)) {
                additionalMap.put(entry.getKey(), entry.getValue());
            }
        }
        return additionalMap;
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

    private static void deleteElementByKey(Map<Purchase, WeekDay> map, Purchase purchase) {
        for(Iterator<Purchase> iterator = map.keySet().iterator(); iterator.hasNext();) {
            Purchase key = iterator.next();
            if(key.getName().equals(purchase.getName())) {
                iterator.remove();
            }
        }
    }

    private static void deleteElementByValue(Map<Purchase, WeekDay> map, List<Purchase> purchases) {
        for(Iterator<Purchase> iterator = map.keySet().iterator(); iterator.hasNext();) {
            Purchase key = iterator.next();
            for (Purchase purchase : purchases) {
                if(key.equals(purchase)) {
                    iterator.remove();
                }
            }
        }
    }

    private static <T> Byn totalCost(List<T> purchases) {
        Byn totalCost = new Byn(0);
        List<Purchase> purchaseList = new ArrayList<>();
        for (T purchase : purchases) {
            purchaseList.add((Purchase) purchase);
        }

        for (Purchase purchase : purchaseList) {
            totalCost = totalCost.add(purchase.getCost());
        }
        return totalCost;
    }

    private static void printCostForWeekdayByEnumMap(Map<WeekDay, List<Purchase>> map) {
        for(Map.Entry<WeekDay, List<Purchase>> entry : map.entrySet()) {
            if (entry.getKey() == WeekDay.MONDAY || entry.getKey() == WeekDay.TUESDAY || entry.getKey() == WeekDay.WEDNESDAY || entry.getKey() == WeekDay.THURSDAY || entry.getKey() == WeekDay.FRIDAY) {
                System.out.println(Constants.TOTAL_COST_FOR_DAY + entry.getKey() + Constants.SPACE + totalCost(entry.getValue()) + Constants.BYN);
            }
        }
    }
}

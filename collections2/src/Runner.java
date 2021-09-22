import by.gsu.epamlab.NumLen;
import constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader(Constants.PATH))) {

            Map<Integer, Integer> lenNumMap = new HashMap<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elements = line.trim().substring(1).trim().split(Constants.REGEX);

                int len = getLen(elements);
                int num = 1;

                if (!lenNumMap.containsKey(len)) {
                    lenNumMap.put(len, num);
                } else {
                    lenNumMap.put(len, lenNumMap.get(len) + 1);
                }
            }
            printMap(lenNumMap);

            List<Map.Entry<Integer, Integer>> list = new ArrayList(lenNumMap.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return 0;
                }
            });

            printCollection(list);
        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + Constants.DELIMITER + entry.getValue());
        }
    }

    private static <K, V> void printCollection(List<Map.Entry<K, V>> list) {
        for (Map.Entry<K, V> entry : list) {
            System.out.println(entry.getKey() + Constants.DELIMITER + entry.getValue());
        }
    }

    private static int getLen(String[] elements) {
        double x1 = Double.parseDouble(elements[Constants.FIRST_ELEMENT]);
        double y1 = Double.parseDouble(elements[Constants.SECOND_ELEMENT]);
        double x2 = Double.parseDouble(elements[Constants.THREE_ELEMENT]);
        double y2 = Double.parseDouble(elements[Constants.FOUR_ELEMENT]);
        return (int) Math.round(Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))));
    }
}

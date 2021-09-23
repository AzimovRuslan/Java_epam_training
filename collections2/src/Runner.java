import by.gsu.epamlab.ValueMapComparator;
import constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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

            SortedMap<Integer, Integer> sortedMapLenNum = new TreeMap<Integer, Integer>(new ValueMapComparator(lenNumMap));
            sortedMapLenNum.putAll(lenNumMap);
            printCollection(sortedMapLenNum.entrySet());

        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static void printCollection(Collection<Map.Entry<Integer, Integer>> entrySet) {
        for (Map.Entry<Integer,Integer> pair : entrySet) {
            System.out.println(pair.getKey() + Constants.DELIMITER + pair.getValue());
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

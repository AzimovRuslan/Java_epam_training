import by.gsu.epamlab.NumLen;
import constants.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader(Constants.PATH))) {
            Set<NumLen> setNumLen = new HashSet<>();
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elements = line.trim().substring(1).trim().split(Constants.REGEX);
                int len = getLen(elements);
                NumLen numLen = new NumLen(len);
                setNumLen.add(numLen);
            }

            List<NumLen> numLens = new ArrayList<>(setNumLen);

            printList(numLens);

            Collections.sort(numLens, new Comparator<NumLen>() {
                @Override
                public int compare(NumLen o1, NumLen o2) {
                    return o2.getNum() - o1.getNum();
                }
            });

            printList(numLens);

        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static void printList(List<NumLen> segments) {
        for (NumLen segment : segments) {
            System.out.println(segment);
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

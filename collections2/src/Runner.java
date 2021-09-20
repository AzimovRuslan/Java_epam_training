import by.gsu.epamlab.Segment;
import constants.Constants;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Segment> segments;

        final String FILENAME = "src/in.txt";
        try(Scanner sc = new Scanner(new FileReader(FILENAME))) {
            segments = new ArrayList<>();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elements = line.trim().substring(1).trim().split("[^-\\d\\.e]+");
                Segment segment = new Segment(elements);
                segment.calculationLen();

                int index = Collections.binarySearch(segments, segment);
                if (index > -1) {
                    segments.get(index).increaseNum();
                } else {
                    segments.add(segment);
                }
            }
            System.out.println("--------------------------------------");
            printList(segments);
            System.out.println("--------------------------------------");

            Collections.sort(segments, new Comparator<Segment>() {
                @Override
                public int compare(Segment o1, Segment o2) {
                    return o2.getNum() - o1.getNum();
                }
            });
            printList(segments);

        } catch (FileNotFoundException e) {
            System.err.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static void printList(List<Segment> segments) {
        for (Segment segment : segments) {
            System.out.println(segment);
        }
    }
}

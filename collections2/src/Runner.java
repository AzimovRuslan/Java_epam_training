import by.gsu.epamlab.Segment;
import constants.Constants;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader(Constants.PATH))) {
            List<Segment> segments = new ArrayList<>();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] elements = line.trim().substring(1).trim().split("[^-\\d\\.e]+");
                Segment segment = new Segment(elements);
                Collections.sort(segments);
                int index = Collections.binarySearch(segments, segment);
                if (index > -1) {
                    segments.get(index).increaseNum();
                } else {
                    segments.add(segment);
                }
            }
            printList(segments);

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

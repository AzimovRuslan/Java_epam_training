import Constants.Constants;
import beans.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = createList();

        printTrials(trials);

        printPassedTrials(trials);

        trials = sortTrials(trials);
        printSumMarks(trials);

        createAndPrintFailedTrials(trials);

        createAndPrintNumberArray(trials);
    }

    private static List<Trial> createList() {
        List<Trial> trials = new ArrayList<>();

        trials.add(new Trial(new Account("Ruslan"), 100, 100));
        trials.add(new Trial(new Account("Kirill"), 50, 50));
        trials.add(new Trial(new Account("Vadim"), 40, 35));
        trials.add(new LightTrial(new Account("Artem"), 40, 40));
        trials.add(new LightTrial(new Account("Pasha"), 30, 20));
        trials.add(new StrongTrial(new Account("Gena"), 100, 90));
        trials.add(new StrongTrial(new Account("Yan"), 20, 20));
        trials.add(new ExtraTrial(new Account("Andrey"), 20, 20, 20));
        trials.add(new ExtraTrial(new Account("Timur"), 100, 100, 100));
        return trials;
    }

    private static void printTrials(List<Trial> trials) {
        trials.forEach(System.out::println);
    }

    private static void printPassedTrials(List<Trial> trials) {
        int passedCount =  (int) trials.stream().filter(trial -> trial.getResult().equals(Constants.PASSED)).count();
        System.out.println(Constants.PASSED_COUNT + passedCount);
    }

    private static List<Trial> sortTrials(List<Trial> trials) {
        return trials.stream().sorted().collect(Collectors.toList());
    }

    private static void printSumMarks(List<Trial> trials) {
        trials.forEach(trial -> System.out.println(trial.getMark1() + trial.getMark2()));
    }

    private static void createAndPrintFailedTrials(List<Trial> trials) {
        List<Trial> failedTrials = trials.stream().filter(trial -> !trial.isPassed()).peek(Trial::clearMark).collect(Collectors.toList());
        failedTrials.forEach(System.out::println);
    }

    private static void createAndPrintNumberArray(List<Trial> trials) {
        int[] arrayMarks = trials.stream().mapToInt(Trial::markSum).toArray();
        System.out.println(Arrays.stream(arrayMarks).mapToObj(Integer::toString).collect(Collectors.joining(Constants.COLLECT_DELIMITER)));
    }
}

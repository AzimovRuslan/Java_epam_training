import Constants.Constants;
import beans.*;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trialList = new ArrayList<>(Arrays.asList(new Trial(new Account("Ruslan"), 100, 100),
                new Trial(new Account("Kirill"), 50, 50),
                new Trial(new Account("Vadim"), 40, 35),
                new LightTrial(new Account("Artem"), 40, 40),
                new LightTrial(new Account("Pasha"), 30, 20),
                new StrongTrial(new Account("Gena"), 100, 90),
                new StrongTrial(new Account("Yan"), 20, 20),
                new ExtraTrial(new Account("Andrey"), 20, 20, 20),
                new ExtraTrial(new Account("Timur"), 100, 100, 100)));

        printTrials(trialList);

        printCountPassedTrials(trialList);

        trialList.sort(((o1, o2) -> sumMark(o1) - sumMark(o2)));

        printSumMarks(trialList);

        createAndPrintFailedTrials(trialList);

        createAndPrintNumberArray(trialList);
    }

    private static int sumMark(Trial trial) {
        return trial.getMark1() + trial.getMark2();
    }

    private static void printTrials(List<Trial> trials) {
        trials.forEach(System.out::println);
    }

    private static void printCountPassedTrials(List<Trial> trials) {
        System.out.println(Constants.PASSED_COUNT + trials.stream().filter(Trial::isPassed).count());
    }

    private static void printSumMarks(List<Trial> trials) {
        trials.stream().map(Runner::sumMark).forEach(System.out::println);
    }

    private static void createAndPrintFailedTrials(List<Trial> trials) {
        List<Trial> failedTrials = trials.stream().filter(trial -> !trial.isPassed()).map(Trial::getCopy).peek(Trial::clearMark).peek(System.out::println).collect(Collectors.toList());
        System.out.println(failedTrials.stream().noneMatch(Trial::isPassed));
    }

    private static void createAndPrintNumberArray(List<Trial> trials) {
        int[] arrayMarks = trials.stream().mapToInt(Runner::sumMark).toArray();
        System.out.println(Arrays.stream(arrayMarks).mapToObj(Integer::toString).collect(Collectors.joining(Constants.COLLECT_DELIMITER)));
    }
}

import Constants.Constants;
import beans.*;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        ToIntFunction<Trial> sumMark = trial -> (trial.getMark1() + trial.getMark2());

        //1
        List<Trial> trialList = new ArrayList<>(Arrays.asList(new Trial(new Account("Ruslan"), 100, 100),
                new Trial(new Account("Kirill"), 50, 50),
                new Trial(new Account("Vadim"), 40, 35),
                new LightTrial(new Account("Artem"), 40, 40),
                new LightTrial(new Account("Pasha"), 30, 20),
                new StrongTrial(new Account("Gena"), 100, 90),
                new StrongTrial(new Account("Yan"), 20, 20),
                new ExtraTrial(new Account("Andrey"), 20, 20, 20),
                new ExtraTrial(new Account("Timur"), 100, 100, 100)));

        //2
        trialList.forEach(System.out::println);

        //3
        System.out.println(Constants.PASSED_COUNT + trialList.stream()
                .filter(Trial::isPassed)
                .count());

        //4
        trialList.sort(Comparator.comparingInt(sumMark));

        //5
        trialList.stream()
                .mapToInt(sumMark)
                .forEach(System.out::println);

        //6
        List<Trial> failedTrials = trialList.stream()
                .filter(trial -> !trial.isPassed())
                .peek(Trial::clearMark)
                .map(Trial::getCopy)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(failedTrials.stream().noneMatch(Trial::isPassed));

        //7
        int[] arrayMarks = trialList.stream()
                .mapToInt(sumMark)
                .toArray();
        System.out.println(Arrays.stream(arrayMarks)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(Constants.COLLECT_DELIMITER)));
    }
}

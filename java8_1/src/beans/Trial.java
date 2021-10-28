package beans;

import Constants.Constants;

public class Trial implements Comparable<Trial>{
    private Account trainee;
    private int mark1;
    private int mark2;
    private static final int PASSING_SCORE = 100;

    public Trial(Account trainee, int mark1, int mark2) {
        this.trainee = trainee;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getResult() {
        String result = "";
        if ((mark1 + mark2) >= PASSING_SCORE) {
            result = Constants.PASSED;
        } else {
            result = Constants.FAILED;
        }
        return result;
    }

    public static int getPassingScore() {
        return PASSING_SCORE;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    @Override
    public String toString() {
        return trainee + Constants.TO_STRING_DELIMITER + getResult();
    }

    @Override
    public int compareTo(Trial o) {
        return (mark1 + mark2) - (o.mark1 + o.mark2);
    }

    public void clearMark() {
        mark1 = 0;
        mark2 = 0;
    }

    public boolean isPassed() {
        return getResult().equals(Constants.PASSED);
    }

    public int markSum() {
        return mark2 + mark1;
    }
}

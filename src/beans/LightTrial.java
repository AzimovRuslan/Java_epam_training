package beans;

import Constants.Constants;

public class LightTrial extends Trial{
    private static final int PASSING_SCORE = 40;

    public LightTrial(Account trainee, int mark1, int mark2) {
        super(trainee, mark1, mark2);
    }

    @Override
    public String getResult() {
        String result = Constants.EMPTY;
        if (getMark1() >= PASSING_SCORE && getMark2() >= PASSING_SCORE) {
            result = Constants.PASSED;
        } else {
            result = Constants.FAILED;
        }
        return result;
    }
}

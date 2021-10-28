package beans;

import Constants.Constants;

public class ExtraTrial extends Trial{
    private static final int PASSING_SCORE = 60;
    private int mark3;

    public ExtraTrial(Account trainee, int mark1, int mark2, int mark3) {
        super(trainee, mark1, mark2);
        this.mark3 = mark3;
    }

    @Override
    public String getResult() {
        String result = "";
        if ((getMark1() + getMark2()) >= PASSING_SCORE && mark3 >= PASSING_SCORE) {
            result = Constants.PASSED;
        } else {
            result = Constants.FAILED;
        }
        return result;
    }

    @Override
    public void clearMark() {
        super.clearMark();
        mark3 = 0;
    }
}

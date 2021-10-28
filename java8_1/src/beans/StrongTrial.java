package beans;

import Constants.Constants;

public class StrongTrial extends Trial{

    public StrongTrial(Account trainee, int mark1, int mark2) {
        super(trainee, mark1, mark2);
    }

    @Override
    public String getResult() {
        String result = "";
        if (getMark1() / 2 + getMark2() >= getPassingScore()) {
            result = Constants.PASSED;
        } else {
            result = Constants.FAILED;
        }
        return result;
    }
}

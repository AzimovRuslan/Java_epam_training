package beans;

import Constants.Constants;

public class StrongTrial extends Trial{

    public StrongTrial(Account trainee, int mark1, int mark2) {
        super(trainee, mark1, mark2);
    }

    @Override
    public String getResult() {
        String result = Constants.EMPTY;
        if (getMark1() / Constants.HALF + getMark2() >= getPassingScore()) {
            result = Constants.PASSED;
        } else {
            result = Constants.FAILED;
        }
        return result;
    }

    @Override
    public Trial getCopy() {
        return this;
    }
}

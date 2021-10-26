import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.ResultFactory;

import java.io.IOException;

public class RunnerInt {
    public static void main(String[] args) {
        ResultFactory factory = new ResultFactory();
        RunnerLogic runnerLogic = new RunnerLogic(Constants.FILENAME_CSV, factory);
        runnerLogic.execute();
    }
}

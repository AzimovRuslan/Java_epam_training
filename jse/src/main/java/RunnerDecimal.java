import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.DecimalResult;
import factories.ResultFactory;

public class RunnerDecimal {
    public static void main(String[] args) {
        ResultFactory factory = new DecimalResult();
        RunnerLogic runnerLogic = new RunnerLogic(Constants.FILENAME_XML, factory);
        runnerLogic.execute();
    }
}

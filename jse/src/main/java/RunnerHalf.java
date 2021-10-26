import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.HalfResult;
import factories.ResultFactory;

public class RunnerHalf {
    public static void main(String[] args) {
        ResultFactory factory = new HalfResult();
        RunnerLogic runnerLogic = new RunnerLogic(Constants.FILENAME_CSV2, factory);
        runnerLogic.execute();
    }
}

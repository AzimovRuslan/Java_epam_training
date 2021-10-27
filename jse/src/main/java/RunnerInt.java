import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.ResultFactory;

public class RunnerInt {
    public static void main(String[] args) {
        ResultFactory factory = new ResultFactory();
        RunnerLogic.execute(Constants.FILENAME_CSV, factory);
    }
}

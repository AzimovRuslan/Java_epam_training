import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.HalfResultFactory;
import factories.ResultFactory;

public class RunnerHalf {
    public static void main(String[] args) {
        ResultFactory factory = new HalfResultFactory();
        RunnerLogic.execute(Constants.FILENAME_CSV2, factory);
    }
}

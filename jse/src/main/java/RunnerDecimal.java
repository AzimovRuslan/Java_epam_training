import by.gsu.epaamlab.RunnerLogic;
import constants.Constants;
import factories.DecimalResultFactory;
import factories.ResultFactory;

public class RunnerDecimal {
    public static void main(String[] args) {
        ResultFactory factory = new DecimalResultFactory();
        RunnerLogic.execute(Constants.FILENAME_XML, factory);
    }
}

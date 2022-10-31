package onboarding.problem3;

public class Controller {
    public static int getSolution(int number) {
        if (Validation.check(number)) {
            SplittedNumber splitNum = new SplittedNumber(number);
            int result = Count.count369(splitNum);
            return result;
        }
        return Constant.EXCEPTION;
    }
}

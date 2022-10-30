package onboarding.problem3;

public class Controller {
    public static int getSolution(int number) {
        if (Validation.check(number)) {
            int result = Count.count369All(number);
            return result;
        }
        return Constant.EXCEPTION;
    }
}

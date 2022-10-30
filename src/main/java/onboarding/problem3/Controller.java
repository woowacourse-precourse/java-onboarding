package onboarding.problem3;

public class Controller {
    public static int getSolution(int number) {
        if (Validation.check(number)) {
            int result = 0;
            for (int i = 1; i < number + 1; i++) {
                result += Count.count369(i);
            }
            return result;
        }
        return Constant.EXCEPTION;
    }
}

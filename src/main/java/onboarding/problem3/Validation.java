package onboarding.problem3;

public class Validation {
    public static boolean check(int number) {
        if (number < Constant.INPUT_MIN || number > Constant.INPUT_MAX) {
            return false;
        }
        return true;
    }
}

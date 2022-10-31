package onboarding.problem5;

public class Validation {
    public static boolean check(int money) {
        if (Constant.MONEY_MIN <= money && money <= Constant.MONEY_MAX) {
            return true;
        }
        return false;
    }
}
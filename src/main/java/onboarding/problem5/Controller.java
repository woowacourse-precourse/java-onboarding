package onboarding.problem5;


import java.util.List;

public class Controller {
    public static List<Integer> getSolution(int money) {
        if (Validation.check(money)) {
            return Money.splitMoney(money);
        }
        return Constant.EXCEPTION;
    }
}

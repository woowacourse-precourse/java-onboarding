package onboarding.problem5;


import java.util.List;

public class Controller {
    public static List<Integer> getSolution(int money) {
        if (Validation.check(money)) {
            List<Integer> result = Money.splitMoney(money);
            return result;
        }
        return Constant.EXCEPTION;
    }
}

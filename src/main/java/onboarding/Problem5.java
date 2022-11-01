package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static onboarding.Problem5.Problem5Validation.validate;

public class Problem5 {
    private static final List<Integer> moneyUnitList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    private static final String MONEY_KEY = "MONEY";
    private static final String COUNT_KEY = "COUNT";

    public static List<Integer> solution(int money) {
        if (!validateInput(money)) {
            return null;
        }
        return calculateMoney(money);
    }

    private static boolean validateInput(int money) {
        return validate(money);
    }

    private static List<Integer> calculateMoney(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer moneyUnit : moneyUnitList) {
            Map<String, Integer> result = calculateMoneyUnitCount(money, moneyUnit, 0);
            money = result.get(MONEY_KEY);
            answer.add(result.get(COUNT_KEY));
        }
        return answer;
    }

    private static Map<String, Integer> calculateMoneyUnitCount(int money, int moneyUnit, int count) {
        if (money < moneyUnit) {
            return Map.of(MONEY_KEY, money, COUNT_KEY, count);
        }
        return calculateMoneyUnitCount(money - moneyUnit, moneyUnit, ++count);
    }

    static abstract class Problem5Validation extends Validation {
        private static final int MIN_VALUE = 1;
        private static final int MAX_VALUE = 1000000;

        public static boolean validate(int money) {
            return validateIntegerRange(money, MIN_VALUE, MAX_VALUE);
        }
    }
}

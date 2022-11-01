package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int MAX_VALUE_OF_MONEY = 1_000_000;

    private static final List<Integer> LIST_OF_MONETARY_UNIT = initMonetaryUnits();

    public static List<Integer> solution(int money) {
        try {
            validateInputSize(money);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return countNumberOfEachUnit(money);
    }

    private static List<Integer> initMonetaryUnits() {
        return List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    }

    private static void validateInputSize(int money) {
        if (money < 1 || money > MAX_VALUE_OF_MONEY) {
            throw new IllegalArgumentException("허용되지 않는 크기의 입력값입니다.");
        }
    }

    private static List<Integer> countNumberOfEachUnit(int money) {
        List<Integer> countList = new ArrayList<>();

        for (int monetaryUnit : LIST_OF_MONETARY_UNIT) {
            countList.add(divide(money, monetaryUnit));
            money = calculateRemainder(money, monetaryUnit);
        }

        return countList;
    }

    private static int divide(int money, int monetaryUnit) {
        return money / monetaryUnit;
    }

    private static int calculateRemainder(int money, int monetaryUnit) {
        return money % monetaryUnit;
    }
}

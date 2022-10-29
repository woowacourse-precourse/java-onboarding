package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<>();

        if (throwBoundaryException(money)) {
            return answer;
        }

        answer.add(calculateFiftyThousand(money));
        money -= 50_000 * answer.get(0);

        answer.add(calculateTenThousand(money));
        money -= 10_000 * answer.get(1);

        answer.add(calculateFiveThousand(money));
        money -= 5_000 * answer.get(2);

        answer.add(calculateOneThousand(money));
        money -= 1_000 * answer.get(3);

        answer.add(calculateFiveHundred(money));
        money -= 500 * answer.get(4);

        answer.add(calculateOneHundred(money));
        money -= 100 * answer.get(5);

        answer.add(calculateFifty(money));
        money -= 50 * answer.get(6);

        answer.add(calculateTen(money));
        money -= 10 * answer.get(7);

        answer.add(calculateOne(money));

        return answer;
    }

    public static boolean throwBoundaryException(int money) {
        return money < 1 || money > 1_000_000;
    }

    public static int calculateFiftyThousand(int money) {
        return money / 50000;
    }

    public static int calculateTenThousand(int money) {
        return money / 10_000;
    }

    public static int calculateFiveThousand(int money) {
        return money / 5_000;
    }

    public static int calculateOneThousand(int money) {
        return money/ 1_000;
    }

    public static int calculateFiveHundred(int money) {
        return money / 500;
    }

    public static int calculateOneHundred(int money) {
        return money / 100;
    }

    public static int calculateFifty(int money) {
        return money / 50;
    }

    public static int calculateTen(int money) {
        return money / 10;
    }

    public static int calculateOne(int money) {
        return money % 10;
    }

}

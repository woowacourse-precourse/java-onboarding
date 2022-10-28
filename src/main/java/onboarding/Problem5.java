package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static List<Integer> answer;

    public static List<Integer> solution(int money) {
        answer = new ArrayList<>();

        money = countFiftyThousand(money);
        money = countTenThousand(money);
        money = countFiveThousand(money);
        money = countThousand(money);
        money = countFiveHundred(money);
        money = countHundred(money);
        money = countFifty(money);
        money = countTen(money);
        countOne(money);

        return answer;
    }

    private static int countFiftyThousand(int money) {
        answer.add(money / 50000);
        return money % 50_000;
    }

    private static int countTenThousand(int money) {
        answer.add(money / 10000);
        return money % 10_000;
    }

    private static int countFiveThousand(int money) {
        answer.add(money / 5000);
        return money % 5_000;
    }

    private static int countThousand(int money) {
        answer.add(money / 1000);
        return money % 1_000;
    }

    private static int countFiveHundred(int money) {
        answer.add(money / 500);
        return money % 500;
    }

    private static int countHundred(int money) {
        answer.add(money / 100);
        return money % 100;
    }

    private static int countFifty(int money) {
        answer.add(money / 50);
        return money % 50;
    }

    private static int countTen(int money) {
        answer.add(money / 10);
        return money % 10;
    }

    private static int countOne(int money) {
        answer.add(money);
        return 0;
    }
}

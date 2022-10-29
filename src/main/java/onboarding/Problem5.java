package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static int money;
    private static List<Integer> answer;

    public static List<Integer> solution(int money) {
        Problem5.money = money;
        answer = new ArrayList<>();

        countFiftyThousand();
        countTenThousand();
        countFiveThousand();
        countThousand();
        countFiveHundred();
        countHundred();
        countFifty();
        countTen();
        countOne();

        return answer;
    }

    private static void countFiftyThousand() {
        answer.add(money / 50000);
        money %= 50_000;
    }

    private static void countTenThousand() {
        answer.add(money / 10000);
        money %= 10_000;
    }

    private static void countFiveThousand() {
        answer.add(money / 5000);
        money %= 5_000;
    }

    private static void countThousand() {
        answer.add(money / 1000);
        money %= 1_000;
    }

    private static void countFiveHundred() {
        answer.add(money / 500);
        money %= 500;
    }

    private static void countHundred() {
        answer.add(money / 100);
        money %= 100;
    }

    private static void countFifty() {
        answer.add(money / 50);
        money %= 50;
    }

    private static void countTen() {
        answer.add(money / 10);
        money %= 10;
    }

    private static void countOne() {
        answer.add(money);
    }
}

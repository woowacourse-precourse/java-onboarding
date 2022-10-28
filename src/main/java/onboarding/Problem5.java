package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        return answer;
    }

    private static int getFiveMillion(int money) {
        return money / 50000;
    }

    private static int getOneMillion(int money) {
        return money / 10000;
    }

    private static int getFiveThousand(int money) {
        return money / 5000;
    }

    private static int getOneThousand(int money) {
        return money / 1000;
    }

    private static int getFiveHundred(int money) {
        return money / 500;
    }

    private static int getOneHundred(int money) {
        return money / 100;
    }

    private static int getFifty(int money) {
        return money / 50;
    }

    private static int getTen(int money) {
        return money / 10;
    }
}

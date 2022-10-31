package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int totalMoney;

    public static List<Integer> solution(int money) {
        totalMoney = money;
        List<Integer> answer = exchangeMoney(money);
        return answer;
    }

    public static List<Integer> exchangeMoney(int money) {
        return Collections.emptyList();
    }

    public static List<Integer> setExchangedMoney() {
        List<Integer> exchangedMoney = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            exchangedMoney.add(0);
        }
        return exchangedMoney;
    }

    public static int exchangeFiftyThousandWon() {
        return 0;
    }

    public static int exchangeTenThousandWon() {
        return 0;
    }

    public static int exchangeFiveThousandWon() {
        return 0;
    }

    public static int exchangeOneThousandWon() {
        return 0;
    }

    public static int exchangeFiveHundredWon() {
        return 0;
    }

    public static int exchangeOneHundredWon() {
        return 0;
    }

    public static int exchangefiftyWon() {
        return 0;
    }

    public static int exchangeTenWon() {
        return 0;
    }

    public static int exchangeOneWon() {
        return 0;
    }
}

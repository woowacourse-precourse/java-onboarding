package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] CoinUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] answerCount = new int[9];

        while (money != 0) {
            money = updateMoneyByCoinUnit(money, CoinUnit, answerCount);
        }

        return Arrays.stream(answerCount)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int updateMoneyByCoinUnit(int money, int[] CoinUnit, int[] answerCount) {
        for (int i = 0; i < CoinUnit.length; i++) {
            if (money >= CoinUnit[i]) {
                money -= CoinUnit[i];
                updateAnswerCount(answerCount, i);
                break;
            }
        }
        return money;
    }

    private static void updateAnswerCount(int[] answerCount, int i) {
        answerCount[i]++;
    }
}

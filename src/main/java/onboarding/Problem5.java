package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] CoinUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] answerCount = new int[9];

        while (money != 0) {
            money = findAnswerCountByCurrentMoney(money, CoinUnit, answerCount);
        }

        return Arrays.stream(answerCount)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int findAnswerCountByCurrentMoney(int money, int[] CoinUnit, int[] answerCount) {
        for (int i = 0; i < CoinUnit.length; i++) {
            if (money >= CoinUnit[i]) {
                money -= CoinUnit[i];
                answerCount[i]++;
                break;
            }
        }
        return money;
    }
}

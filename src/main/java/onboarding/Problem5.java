package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static final int NUM_OF_CURRENCY = 9;

    public static List<Integer> solution(int money) {
        validateMoneySize(money);

        List<Integer> answer = new ArrayList<>();

        getNumOfCurrencies(money, answer);
        return answer;
    }

    private static void getNumOfCurrencies(int money, List<Integer> answer) {
        List<Integer> currencyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int balance = money;

        for (int i = 0; i <= NUM_OF_CURRENCY - 1; i++){
            if (balance <= 0) break;

            int cnt = 0;
            while (currencyList.get(i) <= balance) {
                balance -= currencyList.get(i);
                cnt++;
            }

            answer.add(cnt);
        }

        while (answer.size() < NUM_OF_CURRENCY) {
            answer.add(0);
        }
    }

    private static void validateMoneySize(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException("money의 크기는 1이상 1000000 이하여야 합니다.");
        }
    }
}

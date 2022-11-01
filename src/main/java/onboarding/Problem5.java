package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return calculateMonetaryCount(money);
    }

    static List<Integer> calculateMonetaryCount(int totalMoney) {
        List<Integer> answer = new ArrayList<>();
        int[] monetary = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int money : monetary) {
            int count = calculateMaxCount(totalMoney, money);
            totalMoney = calculateChange(totalMoney, money, count);

            answer.add(count);
        }

        return answer;
    }

    static int calculateMaxCount(int totalMoney, int money) {
        return totalMoney / money;
    }

    static int calculateChange(int totalMoney, int money, int count) {
        if (count == 0) {
            return totalMoney;
        }

        return totalMoney % (money * count);
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>(9);
        int[] result = getWallet(money);
        for (int i : result) answer.add(i);
        return answer;
    }

    static int[] getWallet(int money) {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] moneyValue = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0;i<result.length;i++) {
            result[i] = money / moneyValue[i];
            money %= moneyValue[i];
        }
        return result;
    }
}

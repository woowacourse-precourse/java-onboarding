package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] kindOfMoney = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int[] wallet = new int[9];
        for (int i = 0; i < wallet.length; i++) {
            while (money >= kindOfMoney[i]) {
                wallet[i]++;
                money = money - kindOfMoney[i];
            }
        }
        for (int count : wallet) {
            answer.add(count);
        }

        return answer;
    }
}

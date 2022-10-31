package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();
        for (int j : bill) {
            answer.add(exchangeMoney(money, j));
            money = getChange(money, j);
        }
        return answer;
    }

    private static int getChange(int money, int bill){
        return money % bill;
    }

    private static int exchangeMoney(int money, int k){
        return money / k;
    }
}

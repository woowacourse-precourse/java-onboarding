package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    final static int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        exchangeAllMoney(answer, money);
        return answer;
    }

    public static void exchangeAllMoney (List<Integer> answer, int money){
        for (int j : bill) {
            answer.add(exchangeMoney(money, j));
            money = getChange(money, j);
        }
    }

    private static int getChange(int money, int bill){
        return money % bill;
    }

    private static int exchangeMoney(int money, int k){
        return money / k;
    }
}

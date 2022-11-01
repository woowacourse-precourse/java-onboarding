package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        for (int baseMoney : moneys){
            int moneyCount = getCountOfEachMoney(money, baseMoney);
            money -= moneyCount * baseMoney;
            answer.add(moneyCount);
        }
        return answer;
    }
    public static int getCountOfEachMoney(int money, int baseMoney){
        return money / baseMoney;
    }
}

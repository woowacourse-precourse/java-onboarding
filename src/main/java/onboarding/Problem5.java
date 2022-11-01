package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getCurrency(money);
        return answer;
    }

    public static List<Integer> getCurrency(int money){
        int[] amount = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> wallet = new ArrayList<>();
        for (int i : amount) {
            int curCount = money / i;
            wallet.add(curCount);
            money-=curCount*i;
        }
        return wallet;
    }
}

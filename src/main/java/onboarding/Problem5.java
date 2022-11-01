package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] div = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = caculateBills(money);
        return answer;
    }

    private static List<Integer> caculateBills(int money) {
        List<Integer> wallet = new ArrayList<>();
        for(int i: div){
            wallet.add(money / i);
            money %= i;
        }
        return wallet;
    }
}

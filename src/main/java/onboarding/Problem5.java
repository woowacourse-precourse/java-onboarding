package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int getChange(int money, int bill){
        return money % bill;
    }

    private static int exchangeMoney(int money, int k){
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        return money / bill[k];
    }
}

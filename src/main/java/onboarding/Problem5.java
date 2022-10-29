package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (1 <= money && money <= 1_000_000) {
            answer = getAllNumOfCurrency(money);
        }

        return answer;
    }
    
    private static ArrayList<Integer> getAllNumOfCurrency(int money) {
        int[] divider = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i : divider) {
            temp.add(Integer.valueOf(money / i));
            money %= i;
        }

        return temp;
    }
}

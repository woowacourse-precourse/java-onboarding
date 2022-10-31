package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static final int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<9; i++){
            answer.add(money / bills[i]);
            money %= bills[i];
        }
        return answer;
    }
}

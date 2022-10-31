package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer =  new ArrayList<Integer>(9);
        
        int[] kind = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < kind.length; i++) {
            if (i == 0) {
                answer.add((money / kind[i]));
            } else {
                answer.add(((money % kind[i - 1]) / kind[i]));
            }
        }
        return answer;
    }
}

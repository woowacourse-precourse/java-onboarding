package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] jipae = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < jipae.length; i++) {
            answer.add(money/jipae[i]);
            money %= jipae[i];
        }

        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private final static int[] MONETARY_UNITS = { 50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int remainder = money; 
        for (int unit : MONETARY_UNITS) {
            int count = remainder / unit;
            answer.add(count);
            remainder %= unit;
        }
        return answer;
    }
}

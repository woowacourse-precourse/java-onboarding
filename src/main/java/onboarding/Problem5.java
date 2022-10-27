package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] list = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        int len = 9;

        for(int i = 0; i < len; i++) {
            answer.add(money / list[i]);
            money %= list[i];
        }

        return answer;
    }
}

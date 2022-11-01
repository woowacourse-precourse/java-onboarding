package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> wons = new ArrayList<>(Arrays.asList(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1));
        List<Integer> answer = new ArrayList<>();
        while (money != 0) {
            for (int i = 0; i < wons.size(); i++) {
                answer.add(i, money / wons.get(i));
                money %= wons.get(i);
            }
        }
        return answer;
    }
}
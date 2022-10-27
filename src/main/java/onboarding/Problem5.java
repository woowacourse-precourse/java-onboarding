package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        int index = 0;
        int count = 0;

        while (money > 0) {
            if (money >= moneys[index]) {
                money -= moneys[index];
                count++;
                continue;
            }
        }
        return answer;
    }
}

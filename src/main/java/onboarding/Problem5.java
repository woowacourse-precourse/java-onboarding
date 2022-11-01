package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < 9; i++) {

            if (money == 0) {
                answer.add(0);
                continue;
            }

            int count = money / units[i];

            answer.add(count);
            money -= count * units[i];
        }

        return answer;
    }
}

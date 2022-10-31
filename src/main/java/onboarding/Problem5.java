package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < units.length; i++) {
            int share = money / units[i];
            int remainder = money % units[i];

            answer.add(share);

            money = remainder;
        }

        return answer;
    }
}

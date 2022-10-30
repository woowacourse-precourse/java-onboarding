package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static Integer[] standards = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (Integer standard : standards) {
            int num = money / standard;
            answer.add(num);
            money -= (num * standard);
        }

        return answer;
    }
}

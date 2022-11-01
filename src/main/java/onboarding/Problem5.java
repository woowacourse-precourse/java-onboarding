package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> bill = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for (Integer integer : bill) {
            int quotient = money / integer;
            answer.add(quotient);
            money -= quotient * integer;
        }

        return answer;
    }
}

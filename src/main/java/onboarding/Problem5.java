package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> valueList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (Integer value : valueList) {
            answer.add(money / value);
            money -= (money / value) * value;
        }
        return answer;
    }
}

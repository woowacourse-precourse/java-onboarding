package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        try {
            ExceptionProblem5.validateMoneyRange(money);
        } catch (IllegalArgumentException e) {
            return answer;
        }

        int[] changeUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};


        for (int unit : changeUnit) {
            answer.add(money / unit);
            money %= unit;
        }
        return answer;
    }
}

class ExceptionProblem5 {
    public static void validateMoneyRange(int money) {
        if (money < 1 || money > 1000000) {
            throw new IllegalArgumentException();
        }
    }
}
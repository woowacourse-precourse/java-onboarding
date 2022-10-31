package onboarding;

import onboarding.problem5.Calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        Calculator calculator = new Calculator();
        answer = calculator.func(answer, money);
        return answer;
    }
}

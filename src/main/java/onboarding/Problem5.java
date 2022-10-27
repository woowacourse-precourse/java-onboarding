package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer.add(0, money / 50000);
        money=money-((money/50000)*50000);//5만원
        return answer;
    }
}

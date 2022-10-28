package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> currency = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int temp = money;
        for(int cur : currency) {
            answer.add(temp / cur);
            temp = money % cur;
        }
        return answer;
    }
}
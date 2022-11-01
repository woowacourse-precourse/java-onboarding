package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new LinkedList<>();
        for (int m:moneys){
            answer.add(money / m);
            money %= m;
        }
        return answer;
    }
}

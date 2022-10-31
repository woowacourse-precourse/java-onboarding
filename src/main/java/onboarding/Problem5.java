package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getResult(money);
        return answer;
    }
    public static List<Integer> getResult(int money) {
        List<Integer> result = new ArrayList<>();

        result.add(money/50000);
        result.add(money%50000/10000);
        result.add(money%10000/5000);
        result.add(money%5000/1000);
        result.add(money%1000/500);
        result.add(money%500/100);
        result.add(money%100/50);
        result.add(money%50/10);
        result.add(money%10);

        return result;
    }
}

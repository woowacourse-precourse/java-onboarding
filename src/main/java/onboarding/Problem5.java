package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        for(int i=0; i<currency.length; i++){
            int cur = currency[i];
            answer.add(money/cur);
            money %= cur;
        }
        return answer;
    }
}

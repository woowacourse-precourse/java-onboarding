package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<currency.length; i++){
            int cur = currency[i];
            if(money < cur) {
                answer.add(0);
                continue;
            }
            answer.add(money/cur);
            money %= cur;
        }
        return answer;
    }
}

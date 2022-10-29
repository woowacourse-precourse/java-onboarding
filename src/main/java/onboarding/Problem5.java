package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        for(int i=10000; i>0; i/=10){
            // money / i
            money %= i;
        }
        return answer;
    }

}

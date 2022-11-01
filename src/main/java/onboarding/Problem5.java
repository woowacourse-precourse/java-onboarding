package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] coinType = {50000,10000,5000,1000,500,100,50,10,1};
        int cnt = 0;
        for(int i=0; i<coinType.length; i++){
            answer.add(money/coinType[i]);
            money %= coinType[i];
        }
        return answer;
    }
}

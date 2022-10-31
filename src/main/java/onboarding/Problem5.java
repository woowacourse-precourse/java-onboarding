package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] coin = {50000,10000,5000,1000,500,100,50,10,1};
        int i = 0;
        while(i < coin.length){
            answer.add(money/coin[i]);
            money %= coin[i];
            i++;
        }
        return answer;
    }
}

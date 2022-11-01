package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0));
        List<Integer> coins = new ArrayList<>(Arrays.asList(1,10,50,100,500,1000,5000,10000,50000));
        int size = coins.size();
        for(int i=0;i<size-1;i++){
            int coin = coins.get(i);
            int c = money % coins.get(i+1);
            answer.set(size-1-i,(int)(c/coin));
            money = money - c;
        }
        answer.set(0,(int)(money/50000));
        return answer;
    }
}

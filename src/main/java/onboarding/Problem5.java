package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int coin[] = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i = 0; i < 9; i++){
            //System.out.println((int)(money / coin[i]));
            int cur = (int)(money / coin[i]);
            answer.add(cur);
            money %= coin[i];
        }
        return answer;
    }
}

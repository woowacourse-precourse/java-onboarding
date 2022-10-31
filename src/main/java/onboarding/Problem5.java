package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = greedMoney(money);

        return answer;
    }
    public static List<Integer> greedMoney(int money) {
        List<Integer> result = new ArrayList<>();
        int[] tmp = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0; i<9; i++) {
            result.add(money/tmp[i]);
            money%=tmp[i];
        }
        return result;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> result = new ArrayList<>(); // UnsupportedOperationException방지
        int moneyarr [] = {50000,10000,5000,1000,500,100,50,10,1}; //단위 배열

        for(int i =0; i<moneyarr.length; i++){ //단위 배열과 for문을 활용하여 해결
            result.add(money/moneyarr[i]);
            money %= moneyarr[i];
        }
        answer = result;
        return answer;
    }
}

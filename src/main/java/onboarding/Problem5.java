package onboarding;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyValue =  Collections.emptyList();
        answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        moneyValue = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

        for(int i=0; i<9; i++){
            answer.set(i,money/moneyValue.get(i));
            money = money % moneyValue.get(i);
        }

        return answer;
    }
}

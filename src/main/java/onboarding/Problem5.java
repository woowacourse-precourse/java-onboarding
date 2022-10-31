package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        fillToMoney(answer,money);
        return answer;
    }
    static void fillToMoney(List<Integer> answer,int money){
        int[] cash = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0; i < cash.length;i++){
            answer.add(money / cash[i]);
            money %= cash[i];
        }
    }
}
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());

        //5만원, 1만원, 5천원, 1천원, 5백원, 1백원, 50원, 10원, 1원
        int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};

        for(int i = 0; i < moneyList.length; i++){
            if(money < moneyList[i]){
                answer.add(0);
            }else{
                Integer currency = money / moneyList[i];
                answer.add(currency);
                money -= (currency * moneyList[i]);
            }
        }

        return answer;
    }
}

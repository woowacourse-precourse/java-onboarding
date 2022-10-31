package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();    
        answer = new ArrayList<>();
        String moneyString = Integer.toString(money);
        int moneySize = moneyString.length();
        int[] arrMoney = new int[moneySize+1];
        money = 1000000;
        arrMoney[0] = money/50000;
        arrMoney[1] = money%50000/10000;
        arrMoney[2] = money%50000%10000/5000;
        arrMoney[3] = money%50000%10000%5000/1000;
        arrMoney[4] = money%50000%10000%5000%1000/500;
        arrMoney[5] = money%50000%10000%5000%1000%500/100;
        arrMoney[6] = money%50000%10000%5000%1000%500%100/1;
        for(int i=0; i<arrMoney.length; i++) {
        	answer.add(arrMoney[i]);
        }        
        return answer;
    }
}

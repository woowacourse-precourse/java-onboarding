package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> countMoney(int money){
        int[] typeOfMoney = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> cntOfMoney = new ArrayList<>();
        for(int i=0;i<typeOfMoney.length;i++){
            cntOfMoney.add( money / typeOfMoney[i]);
            money=money- cntOfMoney.get(i) *typeOfMoney[i];
        }
        return cntOfMoney;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = countMoney(money);
        return answer;
    }
}

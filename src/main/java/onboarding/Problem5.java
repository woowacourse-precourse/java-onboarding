package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] moneylist= new int[] {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> countingMoney(List<Integer> count,int money){
        int leftmoney=money;
        for(int i=0;i<10;i++){
            count.add(leftmoney/moneylist[i]);
            leftmoney%=moneylist[i];
        }
        return count;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=countingMoney(answer,money);
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    private static int CHANGES_SIZE = 9;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> changes = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        for(int i=0;i<CHANGES_SIZE;i++){
            answer.add(i,getCoin(money,changes.get(i)));
            money = moneyRemainder(money,changes.get(i));
        }
        return answer;
    }
    public static int getCoin(int money,int coin){
            return money/coin;
    }
    public static int moneyRemainder(int money,int coin){
        return money%coin;
    }
}

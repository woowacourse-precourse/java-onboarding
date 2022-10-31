package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private final static int[] MONEY_UNIT_ARRAY =
            {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = withdrawalMoney(money);

        return answer;
    }
    private static List<Integer> withdrawalMoney(int money){
        List<Integer> counting_Unit = new ArrayList<>();
        for(int won_Amount : MONEY_UNIT_ARRAY){
            counting_Unit.add(money / won_Amount);
            money = money % won_Amount;
        }
        return counting_Unit;
    }

}

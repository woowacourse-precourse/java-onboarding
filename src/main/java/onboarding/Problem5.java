package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        if(!checkMoney(money))
            return answer;

        int temp = money;
        int[] def_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i : def_money){
            answer.add(temp/i);
            temp %= i;
        }
        return answer;
    }

    public static boolean checkMoney(int money){
        return money>0 && money < 1000000;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer = withdrawMoney(answer, money);
        return answer;
    }

    private static List<Integer> withdrawMoney(List<Integer> unit, int money){
        int[] price = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < price.length; i++){
            unit.add(money / price[i]);
            money = money % price[i];
        }
        return unit;
    }
}

package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < 9; i++){
            if(money >= units[i])
                money = withdraw(money, units[i], answer, i);
        }

        return answer;
    }

    static int withdraw (int money, int unit, List<Integer> answer, int i){
        answer.set(i, money/unit);
        return money % unit;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {

        List<Integer> currency = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        List<Integer> answer = new ArrayList<>();

        for(int curCurrency : currency){
            if(money < curCurrency){
                answer.add(0);
            } else if (money >= curCurrency) {
                answer.add(money/curCurrency);
                money -= (money/curCurrency) * curCurrency;
            }
        }

        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> numOfCurrencyBy(List<Integer> currency, int money){
        List<Integer> answer = new ArrayList<>();
        for(int cur:currency){
            answer.add(money / cur);
            money %= cur;
        }
        return answer;
    }
    public static List<Integer> solution(int money) {
        List<Integer> currency = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        return numOfCurrencyBy(currency, money);
    }
}

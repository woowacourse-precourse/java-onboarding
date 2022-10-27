package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyBag = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = new ArrayList<>();

        for(int price : moneyBag){
            answer.add(money/price);
            money = money % price;
        }

        return answer;
    }
}

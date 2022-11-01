package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> unitsOfMoney = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500,100,50,10,1));

        List<Integer> answer = new ArrayList<>(unitsOfMoney.size());

        for(Integer unit : unitsOfMoney){
            answer.add(money/unit);
            money %= unit;
        }

        return answer;
    }
}
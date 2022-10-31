package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if (money<1 || money>1000000)
            return answer;

        answer = new ArrayList<Integer>();
        answer.add(money/50000);
        answer.add((money%50000)/10000);
        answer.add((money%10000)/5000);
        answer.add((money%5000)/1000);
        answer.add((money%1000)/500);
        answer.add((money%500)/100);
        answer.add((money%100)/50);
        answer.add((money%50)/10);
        answer.add((money%10));

        return answer;
    }
}

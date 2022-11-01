package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> cash = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);

        for (int i =0;i<cash.size();i++){
            answer.add(money/cash.get(i));
            money %= cash.get(i);
        }
        return answer;

    }
}

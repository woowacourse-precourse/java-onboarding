package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        final List<Integer> moneyList =
                new ArrayList<Integer>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        for(int i = 0; i < moneyList.size(); i++){
            int moneyCount = money/moneyList.get(i);
            answer.add(moneyCount);
            money = money % moneyList.get(i);
        }
        return answer;
    }
}

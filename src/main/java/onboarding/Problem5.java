package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> getResult(int money){
        List<Integer> moneyUnit = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> ret = new ArrayList<>();
        for(int index= 0;index<moneyUnit.size();index++){
            ret.add(money/moneyUnit.get(index));
            money = (Integer)money%moneyUnit.get(index);
        }
        return ret;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getResult(money);
        return answer;
    }
}

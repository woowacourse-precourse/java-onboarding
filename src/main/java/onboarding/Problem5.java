package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final int moneyType[] = {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withDraw(money);
        return answer;
    }

    public static List<Integer> withDraw(int money){
        List<Integer> result = new ArrayList<>();

        for(int moneyUnit : moneyType){
            if(moneyUnit>money) result.add(0);
            else{
                int count = money/moneyUnit;
                result.add(count);
                money%=moneyUnit;
            }
        }
        return result;
    }
}

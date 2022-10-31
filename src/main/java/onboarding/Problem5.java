package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    private static final List<Integer> values =Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int index=0;
        while (index < values.size()){
            money=calculate(answer,money,values.get(index));
            index++;
        }
        return answer;
    }
    public static int calculate(List<Integer> answer,int money,int value){
        if(money>=value)
            answer.add(money/value);
        if(money<value)
            answer.add(0);
        return money%value;
    }
}

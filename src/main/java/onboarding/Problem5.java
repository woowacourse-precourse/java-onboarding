package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getChange(money);
        return answer;
    }
    private static List<Integer> currency = List.of(50000,10000,5000,1000,500,100,50,10,1);
    private static List<Integer> getChange(int money){
        List<Integer> answer = new ArrayList<>();
        for(Integer item : currency){
            answer.add(money/item);
            money%=item;
        }
        return  answer;
    }
}

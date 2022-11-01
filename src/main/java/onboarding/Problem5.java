package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        Integer[] pocket = {50000,10000,5000,1000,500,100,50,10,1};
        for (int item : pocket){
            if (money/item >0) {
                answer.add(money/item);
            }
            else{
                answer.add(0);
            }
            money%=item;
        }
        return answer;
    }

}

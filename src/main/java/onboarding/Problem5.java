package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> dividors= Arrays.asList(
                50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        ArrayList<Integer> answer=new ArrayList<>();
        for(int i:dividors){
            if(i>money)
                answer.add(0);
            else{
                answer.add(money/i);
                money%=i;
            }
        }

        return answer;
    }
}

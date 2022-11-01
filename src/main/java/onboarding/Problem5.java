package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> cash = List.of(50000,10000,5000,1000,500,100,50,10,1);

        for(int c : cash){
            int num = money / c;
            answer.add(num);
            money %= c;
        }

        return answer;
    }
}

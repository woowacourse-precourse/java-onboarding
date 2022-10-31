package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static Integer[] currencies = new Integer[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int currency : currencies){
            int count = money / currency;
            if ( count > 0 ){
                answer.add(count);
            }
            else{
                answer.add(0);
            }
            money %= currency;
        }

        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> units = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        for(Integer unit : units){
            int cnt;
            if(money >= unit){
                cnt = money / unit;
                answer.add(cnt);
                money %= unit;
            }
            else {
                answer.add(0);
            }
        }
        return answer;
    }
}

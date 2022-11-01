package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] monar = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int cnt = 0;
        for(int mon : monar) {
            while(money >= mon){
                cnt++;
                money -= mon;
            }
            answer.add(cnt);
            cnt = 0;
        }
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    * Greedy로 해결가능. 가장 비싼 금액권부터 최대로 사용한다.
    *
    * */
    public static List<Integer> solution(int money) {
        int[] bills = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<>();
        for(int bill : bills){
            answer.add(money / bill);
            money %= bill;
        }
        return answer;
    }
}

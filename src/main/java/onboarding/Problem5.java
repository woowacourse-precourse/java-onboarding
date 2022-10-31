package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] currency = {50000,10000,5000,1000,500,100,50,10,1};
        //greedy하게 화폐로 나눠지는지 계산
        for(int c : currency){

            answer.add(money/c);
            money = money % c;
        }
        return answer;
    }
}

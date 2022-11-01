package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) throws UnsupportedOperationException{
        try {
            List<Integer> answer = Collections.emptyList(); //TODO:Collections.emptyList가 무엇인가?

            int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
            answer = new ArrayList<>();
            for (int i = 0; i < cash.length; i++) {
                int ae = (money / cash[i]);
                answer.add(ae);
                money -= (cash[i] * ae);
            }
            return answer;
        } catch (UnsupportedOperationException e){
            System.out.println("Not implemented, yet");
        }
        return null;
    }
}

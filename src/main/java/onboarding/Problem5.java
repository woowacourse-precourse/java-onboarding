package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return calculateAnswer(money);
    }

    public static List<Integer> calculateAnswer(int money){
        List<Integer> answer = new ArrayList<>();
        int[] moneyList = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        for (int m : moneyList) {
            if (money >= m) {
                answer.add(money / m);
                money -= m * (money / m);
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}

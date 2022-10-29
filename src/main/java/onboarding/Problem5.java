package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //java.util.ArrayList 지우고 Collections 사용하기.
        //List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int moneyUnit[] = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int quotient;
        for (int i = 0; i < 9; i++){
            quotient = money / moneyUnit[i];
            money = money % moneyUnit[i];
            answer.add(quotient);
        }
        return answer;
    }
}

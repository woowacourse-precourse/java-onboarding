package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int quotient;
        int bill;
        answer.add(50000);
        answer.add(10000);
        answer.add(5000);
        answer.add(1000);
        answer.add(500);
        answer.add(100);
        answer.add(50);
        answer.add(10);
        answer.add(1);

        for (int i = 0; i < 9; i++) {
            bill = answer.get(i);
            quotient = money / bill;
            answer.set(i, quotient);
            money -= bill * quotient;
        }

        return answer;
    }
}

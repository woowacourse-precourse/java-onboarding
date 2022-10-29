package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] change = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < change.length; i++) {
            if (money == 0) {
                break;
            }
            int divide = money / change[i];
            answer.add(i, divide);
            money -= divide * change[i];
        }

        for (int i = answer.size(); i < change.length; i++) {
            answer.add(i, 0);
        }

        return answer;
    }
}

package onboarding;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        final int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = new ArrayList<Integer>();
        int numberOfType = 0;

        for (int i = 0; i < moneyTypes.length; i++) {
            numberOfType = money / moneyTypes[i];
            answer.add(numberOfType);
            money = money % moneyTypes[i];
        }

        return answer;
    }
}

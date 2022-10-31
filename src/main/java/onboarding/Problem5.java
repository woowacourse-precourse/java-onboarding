package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new LinkedList<Integer>();

        int[] moneyarray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<moneyarray.length; i++) {
            int quotient = money/moneyarray[i];
            answer.add(quotient);
            money = money - moneyarray[i] * quotient;
        }

        return answer;
    }
}

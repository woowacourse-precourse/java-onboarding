package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(0,0,0,0,0,0,0,0,0);
        List<Integer> currencies = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        for (int ind = 0; ind < 9; ind++) {
            if (money == 0) {
                break;
            }
            int count = countNumber(money, currencies.get(ind));
            money -= count * currencies.get(ind);
            answer.set(ind, count);
        }
        return answer;
    }

    public static int countNumber(int money, int currency) {
        int quotient = money / currency;
        if (quotient == 0) {
            return 0;
        } else {
            return quotient;
        }
    }
}

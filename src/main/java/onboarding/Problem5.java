package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class Withdrawal {
    List<Integer> money_array = new ArrayList<>(9);

    void setMoneyArray() {
        int m = 50000;
        for (int i=0; i<8; i++) {
            int e = (int) Math.pow(10, i/2);
            if (i % 2 == 0) {
                money_array.add(m/e);
            } else {
                money_array.add(m/(e*5));
            }
        }
        money_array.add(1);
    }
}
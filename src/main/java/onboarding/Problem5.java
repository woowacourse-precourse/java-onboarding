package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> money_count = new ArrayList<>();
        List<Integer> money_list = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        for(int i=0; i<money_list.size(); i++) {
            int money_unit = money_list.get(i);
            money_count.add(money/money_unit);
            money %= money_unit;
        }

        return money_count;
    }
}

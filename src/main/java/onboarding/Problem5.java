package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private final static List<Integer> MONEY_LIST = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> changes = new ArrayList<>(MONEY_LIST.size());

        for (int change : MONEY_LIST) {
            int numOfChange = money / change;
            changes.add(numOfChange);
            money -= change * numOfChange;
        }

        return changes;
    }
}
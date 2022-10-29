package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int a = money;
        List<Integer> change = new ArrayList<>();
        a = oneWon(a,change);


        return change;
    }

    public static int oneWon(int a, List<Integer> change) {
        change.add(a % 10);
        return a / 10;
    }


}

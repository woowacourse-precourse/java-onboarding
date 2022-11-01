package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution (int money) {

        List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> result = new ArrayList<>();

        int tmp = money;

        for (Integer e : unit) {
            result.add(tmp / e);

            tmp = tmp % e;
        }

        return result;
    }
}

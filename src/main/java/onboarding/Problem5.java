package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        var ret = new ArrayList<Integer>();
        for (var u : unit) {
            ret.add(money / u);
            money %= u;
        }
        return ret;
    }
}

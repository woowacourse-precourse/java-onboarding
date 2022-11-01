package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> changes = new ArrayList<>();

        int unit = 50000;
        while (unit > 10) {
            int smaller_unit = unit / 5;
            changes.add(money / unit);
            money %= unit;

            changes.add(money / smaller_unit);
            money %= smaller_unit;
            unit /= 10;
        }
        changes.add(money);
        return changes;
    }
}

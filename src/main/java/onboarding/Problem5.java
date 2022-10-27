package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = ChangeCalculator.calcChanges(money);
        return answer;
    }

}


class ChangeCalculator {
    static List<Integer> calcChanges(int money){
        List<Integer> changes = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < changes.size(); i++) {
            result.add(money/changes.get(i));
            money %= changes.get(i);
        }
        return result;
    }
}


package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        int[] array = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> list = new ArrayList<>();

        for (int i : array) {
            list.add(money / i);
            money %= i;
        }

        return list;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] initial = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Integer[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < monetaryUnit.length; i++) {
            if (i == 0) {
                initial[i] = (money / monetaryUnit[i]);
            }
            if (i > 0) {
                initial[i] = ((money % monetaryUnit[i - 1]) / monetaryUnit[i]);
            }
        }
        return new ArrayList<>(Arrays.asList(initial));
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();
        for (int change : moneyList) {
            result.add(countChange(money, change));
            money %= change;
        }
        return result;
    }

    public static int countChange(int money, int change) {
        return money / change;
    }

}


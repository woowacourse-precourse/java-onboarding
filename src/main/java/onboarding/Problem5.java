package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < units.length; i++) {
            answer.add(withdraw(units[i], money));
            money %= units[i];
        }
        return answer;
    }

    public static int withdraw(int unit, int money) {
        return money / unit;
    }

}

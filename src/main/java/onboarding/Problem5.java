package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int Money;

    public static int getMoney(int unit) {
        int result = Money / unit;
        Money %= unit;
        return result;
    }

    public static List<Integer> solution(int money) {
        Money = money;

        List<Integer> units = new ArrayList<Integer>() {
            {
                add(50000); add(10000); add(5000); add(1000);
                add(500); add(100); add(50); add(10); add(1);
            }
        };

        List<Integer> answer = new ArrayList<>();
        for (Integer i : units) {
            answer.add(getMoney(i.intValue()));
        }

        return answer;
    }
}

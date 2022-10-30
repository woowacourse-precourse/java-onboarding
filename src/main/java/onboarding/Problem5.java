package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] units = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        return answer;
    }

    private static int getQuotientByUnit(int money, int unit) {
        return money / unit;
    }

    private static int getRemainderByUnit(int money, int unit) {
        return money % unit;
    }
}

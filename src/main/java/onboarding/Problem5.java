package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int countUnitInMoney(int num, int idx){
        return num / unit[idx];
    }

    private static boolean isBiggerOrEqualThanUnit(int num, int idx){
        return num >= unit[idx];
    }
}

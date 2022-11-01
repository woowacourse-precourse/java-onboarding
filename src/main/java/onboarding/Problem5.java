package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int[] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int currentUnit : moneyUnit) {
            answer.add(divideAB(money, currentUnit));
            money %= currentUnit;
        }

        return answer;
    }

    private static int divideAB(int a, int b) {
        return a / b;
    }

}

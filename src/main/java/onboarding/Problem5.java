package onboarding;

import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        int money = 15000;
        System.out.println(solution(money));
    }

    private static int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < moneys.length; i++) {
            int m = money / moneys[i];

            money -= moneys[i] * m;
            result.add(m);
        }

        return result;
    }
}

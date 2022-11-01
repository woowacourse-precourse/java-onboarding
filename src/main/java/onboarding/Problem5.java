package onboarding;

import java.util.*;

public class Problem5 {
    /**
     * 화폐 단위를 저장한 전역 정수 배열
     */
    private static int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();

        // 전체 화폐 단위 순회
        for (int i = 0; i < moneys.length; i++) {
            int m = money / moneys[i];
            money -= moneys[i] * m;

            result.add(m);
        }

        return result;
    }
}

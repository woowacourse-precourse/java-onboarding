package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] moneyArr;

    public static List<Integer> solution(int money) {
        createMoneyArr();
        List<Integer> list = resultList(money);
        return list;
    }

    /**
     * 화폐 배열 만들기
     */
    private static void createMoneyArr() {
        moneyArr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }
}

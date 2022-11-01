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

    /**
     * 필요한 화폐 개수만큼 리스트 넣기
     * @param money
     * @return List<Integer>
     */
    private static List<Integer> resultList(int money) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < moneyArr.length; i++) {
            int share = money / moneyArr[i];
            money %= moneyArr[i];
            list.add(share);
        }
        return list;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /**
     * 크기별 돈을 담은 정적 배열을 리턴한다.
     *
     * @return 돈을 담은 배열
     */
    public static int[] getMoneyArray() {
        return new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }

    public static List<Integer> solution(int money) {
        int[] moneyArr = getMoneyArray();
        int i = 0;

        List<Integer> list = new ArrayList<>();

        while (i != 9) {
            int count = money / moneyArr[i];
            money -= moneyArr[i] * count;
            list.add(count);
            i += 1;
        }
        return list;
    }
}

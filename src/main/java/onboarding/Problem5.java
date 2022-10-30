package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     * 가장적은 잔돈의 개수를 구하는 메서드
     *
     * @param money 잔돈으로 바꿀 돈
     * @return 잔돈으로 바꾼 개수 List
     */
    static List<Integer> calcChange(int money) {
        int[] coinsType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < coinsType.length; i++) {
            list.add(0);
        }

        while (money > 0) {
            for (int i = 0; i < coinsType.length; i++) {
                if (coinsType[i] <= money) {
                    list.set(i, list.get(i) + 1);
                    money -= coinsType[i];
                    break;
                }
            }
        }

        return list;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = calcChange(money);
        return answer;
    }
}

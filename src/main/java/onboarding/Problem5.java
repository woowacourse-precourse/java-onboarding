package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
1. 변환된 돈 개수 구하기
 */

public class Problem5 {

    private static List<Integer> countMoney(int money) {
        List<Integer> tmp = new ArrayList<>();
        int[] coin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < coin.length; i ++) {
            tmp.add(money / coin[i]);
            money %= coin[i];
        }
        return tmp;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer = countMoney(money);
        return answer;
    }
}

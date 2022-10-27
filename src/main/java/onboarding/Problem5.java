package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 기능 목록
 * checkValid   : 예외 처리
 */

public class Problem5 {
    static int[] wallet = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        if (!checkValid(money)) {
            return Collections.emptyList();
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            answer.add(money / wallet[i]);
            money = money % wallet[i];
        }
        return answer;
    }

    public static boolean checkValid(int num) {
        return 1 <= num && num <= 1000000;
    }
}

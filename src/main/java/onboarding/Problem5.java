/**
 * 클래스 이름
 * - 문제 5
 *
 * 버전정보
 * - jdk-11.0.17
 *
 * 날짜
 * - 2022-10-31
 *
 */

package onboarding;


import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] coinType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int coin : coinType) {
            int coinCount = money / coin;
            money %= coin;
            answer.add(coinCount);
        }
        return answer;
    }
}

/**
 * 클래스 이름
 * - 문제 5
 *
 * 버전정보
 * - openjdk version "11.0.15"
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

        int[] cashType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int cash : cashType) {
            int count = money / cash;
            money %= cash;
            answer.add(count);
        }
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. 큰 금액부터 나누어서 몫이 있다면 정답 배열에 담는 함수
 */
public class Problem5 {
    static final int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int coin : coins) {
            answer.add(money / coin);
            money -= (money / coin) * coin;
        }
        return answer;
    }
}

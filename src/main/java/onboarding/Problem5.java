package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static final int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for (int amount : currencies) {
            int[] result = countOfMoneyToNeed(money, amount);
            money = result[0];
            answer.add(result[1]);
        }

        return answer;
    }

    private static int[] countOfMoneyToNeed(int money, int amount) {
        int result = 0;
        while (money >= amount) {
            result++;
            money -= amount;
        }
        return new int[]{money, result};
    }
}

/* 구현 로직
 * 1. 제일 큰 금액부터 작은 금액까지 탐색한다.
 * 2. 선택된 금액보다 크면
 *   2-1. 선택된 금액만큼 빼주고
 *   2-2. 선택된 금액보다 작은지 다시 확인한다.
 *       2-2-1.작으면 다음 금액으로
 *       2-2-2.크면 다시 2-1로 간다.
 * 3. 작으면 다음 금액으로 넘어간다.
 * */

/* 기능 목록
 * 1. 큰 금액에서 작은 금액으로 차례대로 탐색하는 메소드
 *   2. 지금 비교하는 금액에서 돈이 얼마나 필요한지 반환해주는 메소드
 * */
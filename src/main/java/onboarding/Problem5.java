package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. 현재 돈에서 변환할 수 있는 가장 큰 금액 구하기
 * 2. 전체 돈을 변환한 결과 구하기
 */

public class Problem5 {
    private static final List<Integer> bills = List.of(
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    );

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int bill : bills) {
            answer.add(getMoneyWithBill(money, bill));
            money %= bill;
        }
        return answer;
    }

    /**
     * 현재 지폐를 이용해 변환할 수 있는 가장 큰 금액 구하기
     *
     * @param money
     * @param bill
     * @return bill 으로 바꿀 수 있는 돈 액수
     */
    private static int getMoneyWithBill(int money, int bill) {
        if (money >= bill) {
            return money / bill;
        }
        return 0;
    }
}

package onboarding;

import onboarding.problem5.PaymentCounter;

import java.util.List;

/**
 * Problem 5 기능 목록
 * - 화폐 단위별 개수를 그리디로 탐색
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        PaymentCounter calculator = new PaymentCounter(new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1});
        return calculator.count(money);
    }
}

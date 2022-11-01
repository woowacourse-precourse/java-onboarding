package onboarding;

import onboarding.problem5.MonetaryUnitCounter;

import java.util.List;

/**
 * Problem 5 기능 목록
 * 1. 화폐 단위별 개수를 그리디로 탐색
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        MonetaryUnitCounter calculator = new MonetaryUnitCounter(new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1});
        return calculator.count(money);
    }
}

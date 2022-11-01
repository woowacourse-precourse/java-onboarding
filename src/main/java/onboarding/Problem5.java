/*
 * Problem5.java
 *
 * 2022-10-29
 *
 */
package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 우아한 테크코스 - 프리코스 1주차 돈 액수 구하기
 *
 * @author 이준현
 * @version 1.00 2022년 10월 29일
 */
public class Problem5 {

    /**
     * 금액이 큰 순서대로 장수를 구할 지폐의 금액을 명시한 List
     */
    private static final List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    /**
     * 입력받은 금액이 문제에 유효한 값인지 확인
     *
     * @param money 유효성 검증할 입력값
     * @return 유효할시 true, 유효하지 않을시 false
     */
    public static boolean validCheck(int money) {
        return money >= 1 && money <= 1000000;
    }

    /**
     * 지폐의 금액에 따라 장수를 구하는 method
     *
     * @param money 장수를 구할 금액의 크기
     * @return 금액별 장수 (Integer)가 담긴 List
     */
    public static List<Integer> getSortedMoney(int money) {
        List<Integer> result = new ArrayList<>();
        for (Integer list : moneyList) {
            result.add(money / list);
            money %= list;
        }
        return result;
    }

    /**
     * 지폐의 금액별 장수를 구해 전달하는 solution method
     *
     * @param money 장수를 구할 금액
     * @return 크기가 큰 순서대로 장수가 담긴 List
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if (!validCheck(money)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        answer = getSortedMoney(money);
        return answer;
    }
}

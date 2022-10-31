package onboarding;

import java.util.Collections;
import java.util.List;

/*
* 기능 목록
* 1. 금액 단위가 주어졌을 때 반환되는 동전 개수 구하기
* 2. 모든 단위별 동전 개수 구하기
* */
public class Problem5 {

    // 금액 단위가 주어졌을 때 반환되는 동전 개수 구하기
    public static int getMoneyCount(int money, int moneyUnit, List<Integer> answer) {
        answer.add(money / moneyUnit);
        // 남은 돈 리턴
        return money % moneyUnit;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

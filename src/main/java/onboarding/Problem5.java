package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 0. 기본 조건
 * - money는 1 이상 1,000,000 이하인 자연수이다.
 * - 50,000 / 10,000 / 5,000 / 1,000 / 500 / 100 / 50 / 10 / 1
 *
 * 1. 접근 방식
 * - 50000원부터 1원까지 큰 금액부터 점점 빼 나가 카운트 해준다.
 * */
public class Problem5 {
    public static List<Integer> solution(int money) {
        Problem5 problem5 = new Problem5();
        List<Integer> answer = new ArrayList<>();

        // 50000원권 계산
        answer.add(problem5.countBill(money, 50000));
        money = problem5.countOutMoney(money,50000,answer.get(0));
        // 10000원권 계산
        answer.add(problem5.countBill(money, 10000));
        money = problem5.countOutMoney(money,10000,answer.get(1));
        // 5000원권 계산
        answer.add(problem5.countBill(money, 5000));
        money = problem5.countOutMoney(money,5000,answer.get(2));
        // 1000원권 계산
        answer.add(problem5.countBill(money, 1000));
        money = problem5.countOutMoney(money,1000,answer.get(3));
        // 500원권 계산
        answer.add(problem5.countBill(money, 500));
        money = problem5.countOutMoney(money,500,answer.get(4));
        // 100원권 계산
        answer.add(problem5.countBill(money, 100));
        money = problem5.countOutMoney(money,100,answer.get(5));
        // 50원권 계산
        answer.add(problem5.countBill(money, 50));
        money = problem5.countOutMoney(money,50,answer.get(6));
        // 10원권 계산
        answer.add(problem5.countBill(money, 10));
        money = problem5.countOutMoney(money,10,answer.get(7));
        // 1원권 계산
        answer.add(problem5.countBill(money, 1));

        return answer;
    }

    // 금액에서 원하는 지폐로 얻을 수 있는 수 구하기
    public int countBill(int money, int targetBill){
        return (money/targetBill);
    }

    // 금액에서 원하는 지폐 몇장을 뺀 결과 금액 구하기
    public int countOutMoney(int money, int bill, int billCount){
        return money - (bill * billCount);
    }
}

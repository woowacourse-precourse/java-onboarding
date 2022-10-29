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

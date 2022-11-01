package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
//    기능 요구 사항
//      계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.
//
//      돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전,
//      백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
//
//      제한사항
//      money는 1 이상 1,000,000 이하인 자연수이다.
//      실행 결과 예시
//      money	result
//      50237	[1, 0, 0, 0, 0, 2, 0, 3, 7]
//      15000	[0, 1, 1, 0, 0, 0, 0, 0, 0]

    //    -- 요약 --
//    1. 높은 금액 돈단위별로 나누어서 나머지가 0이 되게 해보면 되지않을까?
//    2. 매개변수는 int 형
//    3. 비교 대상은 List 인터페이스
//     int money = 50_237;
//     List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = countMoney(money);
        System.out.println(answer); // 결과 확인(임시)
        return answer;
    }

    public static List<Integer> countMoney(int money) {
        List<Integer> result = new ArrayList<>();
        result.add(money / 50000); // 5만원으로 나눈 몫이 있다면 카운트
        money %= 50000;      // 5만원으로 나눈 나머지는 다른 돈단위로
        result.add(money / 10000);  //위와 동일 반복
        money %= 10000;
        result.add(money / 5000);
        money %= 5000;
        result.add(money / 1000);
        money %= 1000;
        result.add(money / 500);
        money %= 500;
        result.add(money / 100);
        money %= 100;
        result.add(money / 50);
        money %= 50;
        result.add(money / 10);
        money %= 10;
        result.add(money);      // 일원 동전
        return result;
    }
}

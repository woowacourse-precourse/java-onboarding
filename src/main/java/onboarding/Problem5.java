package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. 입력된 돈을 최대한 가볍도록 출금하기 위해서 큰 금액의 화폐부터 교환하여 다양한 화폐의 수 리턴
        - 특정 화폐로 교환했을 때, 특정 화폐 수 얻음
        - 특정 화폐로 교환했을 때, 나머지 금액을 얻음
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer.add(money / 50000); // 50000원짜리 개수 반환
        money %= 50000; // 50000원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 10000);   // 10000원짜리 개수 반환
        money %= 10000; // 10000원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 5000);    // 5000원짜리 개수 반환
        money %= 5000; // 5000원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 1000);    // 1000원짜리 개수 반환
        money %= 1000; // 1000원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 500); // 500원짜리 개수 반환
        money %= 500; // 500원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 100); // 100원짜리 개수 반환
        money %= 100; // 100원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 50);  // 50원짜리 개수 반환
        money %= 50; // 50원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money/ 10);  // 10원짜리 개수 반환
        money %= 10; // 10원짜리 화폐로 교환시 나머지 금액 반환
        answer.add(money);  // 1원짜리 개수 반환
        return answer;
    }
}

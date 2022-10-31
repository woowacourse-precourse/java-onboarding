package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
제한사항
money는 1 이상 1,000,000 이하인 자연수이다.

기능 목록
1. answer 가변 객체로 변경
2. list에 각각의 지폐로 지불 할 몫 추가
3. money 값 변경
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer.add(money/50000);
        money %= 50000;
        answer.add(money/10000);
        money %= 10000;
        answer.add(money/5000);
        money %= 5000;
        answer.add(money/1000);
        money %= 1000;
        answer.add(money/500);
        money %= 500;
        answer.add(money/100);
        money %= 100;
        answer.add(money/50);
        money %= 50;
        answer.add(money/10);
        money %= 10;
        answer.add(money);
        return answer;
    }
}

package onboarding;

import java.util.Collections;
import java.util.List;

/*
오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
 금액이 큰 순서대로 => 나눠서 리스트에 추가
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        answer.add(money/50000);
        money%=50000;
        answer.add(money/10000);
        money%=10000;
        answer.add(money/5000);
        money%=5000;
        answer.add(money/1000);
        money%=1000;
        answer.add(money/500);
        money%=500;
        answer.add(money/100);
        money%=100;
        answer.add(money/50);
        money%=50;
        answer.add(money/10);
        money%=10;
        answer.add(money/1);

        return answer;
    }
}

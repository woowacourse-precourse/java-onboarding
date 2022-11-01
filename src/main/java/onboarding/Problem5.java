package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        // 지폐 및 동전 list
        List<Integer> coin = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        // 화폐의 개수 (9개)만큼 그리디하게 변환한다.
        for (int i = 0; i < 9; i++) {
            int div = coin.get(i);
            answer.add(money/div);
            money %= div;
        }
        return answer;
    }
}

// 문제요구사항
// 1. 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원 (9개) 순서
// 2. 화폐 위주로
// 예외 처리
// 1. 제한 사항 외 문제가 될만한 것 없어보인다.
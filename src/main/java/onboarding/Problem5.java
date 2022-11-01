package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 변환할 화폐 종류를 금액이 큰 순서대로 넣은 배열 선언
        int unit[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 금액이 큰 순서대로 변환 받고 answer 리스트에 삽입
        for (int i = 0; i < 9; i++) {
            answer.add((money/unit[i]));
            money %= unit[i];
        }
        return answer;
    }
}

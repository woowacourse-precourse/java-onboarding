package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 1. 화폐단위 배열 생성
    // 2. 입력된 money를 withdraw 함수로 해석
    // 3. 해석된 결과 리스트 반환

    static int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        withdraw(money, answer, 0);
        return answer;
    }

    static void withdraw(int money, List<Integer> answer, int step) {
        // 1. withdraw 함수 탈출 조건 : 화폐 단위의 개수 만큼 반복
        // 2. 입력된 money를 n번째(step)화폐 단위로 나누고 값은 answer에 저장,
        // 나머지 값은 다음 화폐 단위와 함께 withdraw에 입력
        if (step < 9) {
            int unit = monetaryUnit[step];
            answer.add(money / unit);
            int restMoney = money % unit;
            step++;
            withdraw(restMoney, answer, step);
        }
    }
}

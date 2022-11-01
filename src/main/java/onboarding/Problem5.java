package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 예외처리
        try {
            if(money < 1 || money > 1000000 ) {
                throw  new Exception("금액의 범위를 벗어났습니다.");
            }
        } catch (Exception e) {
            System.out.println("Exception :: " + e.getMessage());
            return new ArrayList<>();
        }

        // 1. 돈의 단위 배열 생성
        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 2. 가장 큰 다위 화폐부터 사용
        for (int i : moneyArr) {
            answer.add(money / i);
            money = money % i;
        }

        return answer;
    }
}

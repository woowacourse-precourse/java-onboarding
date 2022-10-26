package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] amounts = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 }; // 5만원 권부터 1원 동전까지

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < amounts.length; i++) {
            int amount = amounts[i];
            int count = 0;

            // 현재 가지고 있는 돈이 화폐 단위보다 크면 실행
            while(money >= amount) {
                money -= amount;    // 해당 금액만큼 차감
                count++;            // 카운트
            }

            answer.add(count);
        }

        return answer;
    }
}

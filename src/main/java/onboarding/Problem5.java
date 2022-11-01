package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] amounts = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 }; // 5만원짜리 지폐부터 1원 동전

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int amount : amounts) {
            int count = money / amount; // 출금 가능한 최대 개수
            money -= (amount * count);  // 현재 가진 돈에서 출금한 금액만큼 차감

            answer.add(count);
        }

        return answer;
    }
}

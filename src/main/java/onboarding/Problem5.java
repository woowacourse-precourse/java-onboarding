package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    // 액수 단위를 저장하는 리스트 추가하기
    private static List<Integer> amounts = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>(9);

        int amount;
        for (int i = 0; i < amounts.size(); i++) {
            amount = amounts.get(i);
            if (money / amount > 0) {
                answer.add(money / amount);
                money %= amount;
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}

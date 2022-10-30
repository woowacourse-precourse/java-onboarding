package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 화폐의 종류를 cash 배열로 초기화.
        int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // money 를 cash 의 값으로 나누었을때의 몫이 화폐의 수.
        for (int i : cash) {
            // 가장 큰 값의 50000 화폐의 개수를 찾고
            answer.add(money / i);
            // 다음 화폐의 개수를 찾기위해 money 재정의.
            money %= i;
        }

        return answer;
    }
}

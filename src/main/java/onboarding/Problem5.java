package onboarding;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 화폐의 종류

        // 금액이 큰 화폐 순서대로 화폐를 받는 기능
        for (int cash: moneyArr) {
            // 현재 화페로 받을 수 있는 최대 개수를 구하는 기능
            int cashCount = money / cash;
            answer.add(cashCount);
        }
        return answer;
    }
}

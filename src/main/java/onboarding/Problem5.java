package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     * 기능 목록
     * 1. 화폐 단위를 배열로 만들고
     * 2. 단위보다 money가 크다면 money를 단위로 나눈 나머지를 뺀다
     * 3. 그 수를 단위로 나눠서 나온 지폐 수를 answer에 저장
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] krw = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int won : krw) {
            if (money >= won) {
                answer.add((money - money % won) / won);
                money = money % won;
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        // unit: 환산 가능한 화폐 단위를 나타내는 배열
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10 ,1};
        // count: 각 화폐의 개수를 저장하는 리스트
        List<Integer> count = new ArrayList<>();

        // 각 화폐마다 반복
        for(int unit: units) {
            // 현재 금액을 화폐로 나눠서 개수를 구하고 남은 금액을 다음 반복으로 넘김
            count.add(money / unit);
            money %= unit;
        }
        answer = count;

        return answer;
    }
}

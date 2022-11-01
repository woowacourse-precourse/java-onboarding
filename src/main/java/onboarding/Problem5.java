package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 각 화폐 단위를 저장하는 리스트를 생성.
    // 반복문을 돌려서 리스트와 money를 계속 업데이트.

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        int[] divide = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int d : divide) {
            answer.add(money / d);
            money %= d;
        }

        return answer;
    }
}

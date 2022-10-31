package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getChange(money);

        return answer;
    }

    // 화폐 크기 lookup 테이블
    private static List<Integer> currency = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    // 그리디 알고리즘은 화폐 변환
    private static List<Integer> getChange(int money){
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < currency.size(); i++) {
            answer.add(money/currency.get(i));
            money %= currency.get(i);
        }

        return answer;
    }
}

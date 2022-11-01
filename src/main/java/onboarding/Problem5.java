package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        // 화폐의 단위를 설정한다.
        int [] currency = {50_000, 10_000, 5_000, 1_000, 500, 100 ,50, 10, 1};

        for(int i: currency){
            answer.add(calculate_number(money, i));
            money %=i;
        }
        return answer;
    }

    // 해당 화폐로 나눈다.
    public static int calculate_number(int money, int currency){
        return money/currency;
    }
}

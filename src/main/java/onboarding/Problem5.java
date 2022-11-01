package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int arr[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 큰 단위 금액부터 나누어 answer에 담기
        for(int i=0; i<arr.length; i++) {
            if(money >= arr[i]) {
                answer.add(money / arr[i]);
                money = money % arr[i];
            } else {
                answer.add(0);
            }
        }

        return answer;
    }
}

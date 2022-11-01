package onboarding;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();
        int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 큰수부터 차례대로 반복문
        for (int unit : moneyUnits) {
          int count = money / unit;
          money = money % unit;
          answer.add(count); // 각 금액별로 나눈 값을 배열에 추가
        }
        
        return answer;
    }
}

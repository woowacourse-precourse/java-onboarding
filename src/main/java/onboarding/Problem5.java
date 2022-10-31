package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> tmpanswer = new ArrayList<>();

        // 화폐 단위의 ArrayList를 만든다.
        ArrayList<Integer> moneyUnit = new ArrayList<>(
                List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
        );

        // 제일 큰 화폐부터 먼저 바꾸고 나머지는 차레대로 다음 화폐단위로 바꾼다. (greedy)
        for (Integer unitCurrency : moneyUnit) {
            // 돈을 화폐 단위로 바꾼다.
            int numberOfCurrency = money / unitCurrency;
            // 변환된 화폐 개수를 저장한다.
            tmpanswer.add(numberOfCurrency);
            // 바꾸고 남은 나머지를 재선언한다.
            money = money % unitCurrency;
        }

        answer = tmpanswer;
        return answer;
    }
}

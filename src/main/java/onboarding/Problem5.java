package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int[] unitOfMoneys = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        int[] tmpAnswer = new int[unitOfMoneys.length];

        /*금액이 큰 순서대로 추가*/
        for (int i = 0; i < unitOfMoneys.length; ++i) {
            int moneyReturned = money / unitOfMoneys[i];
            if (moneyReturned > 0) {
                tmpAnswer[i] = moneyReturned;
                money -= moneyReturned * unitOfMoneys[i];
            }
        }

        answer = Arrays.stream(tmpAnswer)
                        .boxed()
                        .collect(Collectors.toList());
        return answer;
    }
}

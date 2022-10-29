package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] answer = new int[9];
        int[] divide = new int[]{5, 2, 5, 2, 5, 2, 5, 10};
        int divideAmount = 50000;

        for (int i = 0; i < 8; i++) {
            answer[i] = money / divideAmount;
            money = money % divideAmount;
            divideAmount /= divide[i];
        }

        answer[8] = money / divideAmount;

        return Arrays.stream(answer)
                .boxed()
                .collect(Collectors.toList());
    }
}

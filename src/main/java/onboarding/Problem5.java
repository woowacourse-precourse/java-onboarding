package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int i = 0; i < unit.size(); i++) {
            answer[i] += money / unit.get(i);
            money %= unit.get(i);
        }

        return Arrays.stream(answer).boxed().collect(Collectors.toList());
    }
}

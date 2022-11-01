package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        List<Integer> stream = IntStream.range(1, number+1)
                .boxed()
                .collect(Collectors.toList());

        return answer;
    }

}

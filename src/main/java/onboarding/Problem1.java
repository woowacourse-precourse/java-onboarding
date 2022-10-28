package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    private static List<Integer> toDigitList(Integer num) {
        return Arrays.stream(num.toString()
                .split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
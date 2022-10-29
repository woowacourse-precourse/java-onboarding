package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int[] splitNum(Integer num) {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }
}
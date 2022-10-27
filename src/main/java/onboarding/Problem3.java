package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    private static final int THREE = 3;
    private static final int SIX = 6;
    private static final int NINE = 9;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int computeClapCount(int num) {
        List<Integer> only369 = List.of(THREE, SIX, NINE);

        return (int) Arrays.stream(String.valueOf(num)
                .split(""))
            .filter(n -> only369.contains(n))
            .count();
    }
}

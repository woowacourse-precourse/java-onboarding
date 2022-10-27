package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    public static int solution(int number) {
        int[] numRange = getNumRange(number);
        return 0; // 임시
    }

    private static int[] getNumRange(int number) {
        return IntStream.rangeClosed(1, number).toArray();
    }
}

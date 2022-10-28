package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    private static final List<Integer> checkNumbers = Arrays.asList(3, 6, 9);
    private static int count = 0;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static void checkRole(int number) {
        if (checkNumbers.contains(number)) {
            count += 1;
        }
    }
}

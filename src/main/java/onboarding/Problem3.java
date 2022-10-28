package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final List<Integer> checkNumbers = Arrays.asList(3, 6, 9);
    private static int count = 0;

    public static int solution(int number) {
        IntStream.range(1, number+1).forEach(Problem3::checkRole);
        return count;
    }

    private static void checkRole(int number) {
        while(number != 0) {
            if(checkNumbers.contains(number%10)) {
                count++;
            }

            number /= 10;
        }
    }
}

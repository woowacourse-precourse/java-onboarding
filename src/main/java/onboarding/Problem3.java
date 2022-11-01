package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {
    private static final Integer EXCEPTION = -1;
    public static int solution(int number) {
        return restrictions(number)
                ? EXCEPTION
                : clapCount(number);
    }

    private static boolean restrictions(int number) {
        return number < 1 || number > 10000;
    }

    private static int[] find369(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(num -> String.valueOf(num).matches("^[0-9]*[369][0-9]*$"))
                .toArray();
    }

    private static int clapCount(int number) {
        return Arrays.toString(find369(number))
                .replaceAll("[^369]","")
                .length();
    }
}

package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {

    static int[] Dy;

    static void preProcess() {
        Dy[1] = 0;
    }

    static int[] getDigitArr(int number) {
        return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
    }

    private static int getClapCount(int[] digitArr) {
        return Arrays.stream(digitArr)
                .filter(digit -> digit == 3 || digit == 6 || digit == 9)
                .reduce(0, (answer, count) -> answer + 1);
    }

    public static int solution(int number) {
        Dy = new int[number + 1];

        for (int i = 2; i <= number; i++) {
            final int[] digitArr = getDigitArr(i);
            Dy[i] = getClapCount(digitArr) + Dy[i - 1];
        }

        return Dy[number];
    }
}

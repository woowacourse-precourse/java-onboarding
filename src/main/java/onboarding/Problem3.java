package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {

    private static final Integer NUMBER_MINIMUM_LENGTH = 1;
    private static final Integer NUMBER_MAXIMUM_LENGTH = 10000;

    static int[] Dy;

    static void input(int number) {
        Dy = new int[number + 1];
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
        validateNumber(number);
        input(number);

        for (int i = 2; i <= number; i++) {
            final int[] digitArr = getDigitArr(i);
            Dy[i] = getClapCount(digitArr) + Dy[i - 1];
        }

        return Dy[number];
    }

    private static void validateNumber(int number) {
        if (number < NUMBER_MINIMUM_LENGTH || number > NUMBER_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("number는 1 이상 10,000 이하인 자연수입니다.");
        }
    }
}

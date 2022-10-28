package onboarding.problem3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApplauseGame {
    private static final int MIN = 1;
    private static final int MAX = 10_000;

    public static int start(int number) {
        checkInput(number);
        String numbers = joinNumbers(number);
        int clap = 0;
        for (int i = 0; i < numbers.length(); i++) {
            clap = addClap(numbers, clap, i);
        }
        return clap;
    }

    private static void checkInput(int number) {
        validateMin(number);
        validateMax(number);
    }

    private static void validateMax(int number) {
        if (number > MAX) {
            throw new ApplauseException("10000이하의 숫자를 입력해주세요");
        }
    }

    private static void validateMin(int number) {
        if (number < MIN) {
            throw new ApplauseException("1이상 숫자를 입력해주세요.");
        }
    }

    private static int addClap(String numbers, int count, int i) {
        if (isClap(numbers, i)) {
            count++;
        }
        return count;
    }

    private static String joinNumbers(int number) {
        return IntStream.range(1, number + 1).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private static boolean isClap(String string, int i) {
        return string.charAt(i) == '3' || string.charAt(i) == '6' || string.charAt(i) == '9';
    }

}

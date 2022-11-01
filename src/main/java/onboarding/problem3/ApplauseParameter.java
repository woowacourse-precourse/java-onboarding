package onboarding.problem3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApplauseParameter {
    private static final int MIN = 1;
    private static final int MAX = 10_000;

    private final String numbers;

    public ApplauseParameter(int number) {
        checkInput(number);
        this.numbers = joinNumbers(number);
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

    private static String joinNumbers(int number) {
        return IntStream.range(1, number + 1).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public String getNumbers() {
        return numbers;
    }
}

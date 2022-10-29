package problem3;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Game369ClapCounter {
    private static final int LOWER_BOUNDS = 1;
    private static final int UPPER_BOUNDS = 10000;
    private static final String ERR_BOUNDS_ERROR = "입력 숫자는 1 이상 10000 이하입니다.";
    private static final Set<Integer> claps = new HashSet<>();

    static {
        claps.add(3);
        claps.add(6);
        claps.add(9);
    }

    public static int countFromOneTo(int lastNumber) {
        validateBounds(lastNumber);

        return IntStream.rangeClosed(LOWER_BOUNDS, lastNumber)
                .reduce(0, (counted, num) -> counted + countClaps(num));
    }

    private static int countClaps(int num) {
        return String.valueOf(num)
                .chars()
                .map(Character::getNumericValue)
                .map(digit -> clapOf(digit))
                .sum();
    }

    private static int clapOf(int digit) {
        if (claps.contains(digit)) {
            return 1;
        }
        return 0;
    }

    private static void validateBounds(int number) {
        if (number < LOWER_BOUNDS || number > UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_BOUNDS_ERROR);
    }
}

package problem3;

import java.util.HashSet;
import java.util.Set;

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

        int result = 0;

        for (int num = LOWER_BOUNDS; num <= lastNumber; num++) {
            result += countClaps(num);
        }
        return result;
    }

    private static int countClaps(int num) {
        int result = 0;

        while (num > 0) {
            result += clapDigit(num % 10);
            num /= 10;
        }

        return result;
    }

    private static int clapDigit(int digit) {
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

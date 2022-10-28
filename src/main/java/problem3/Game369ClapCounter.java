package problem3;

import java.util.HashSet;
import java.util.Set;

public class Game369ClapCounter {
    private static final int LOWER_BOUNDS = 1;
    private static final int UPPER_BOUNDS = 10000;
    private static final String ERR_BOUNDS_ERROR = "입력 숫자는 1 이상 10000 이하입니다.";
    private static final Set<Integer> targets = new HashSet<>();

    static {
        targets.add(3);
        targets.add(6);
        targets.add(9);
    }

    public static int countFromOneTo(int last) {
        validateBounds(last);

        int result = 0;

        for (int num = LOWER_BOUNDS; num <= last; num++) {
            result += countTargets(num);
        }
        return result;
    }

    private static int countTargets(int num) {
        int count = 0;

        while (num > 0) {
            if (targets.contains(num % 10)) {
                count += 1;
            }
            num /= 10;
        }

        return count;
    }

    private static void validateBounds(int number) {
        if (number < LOWER_BOUNDS || number > UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_BOUNDS_ERROR);
    }
}

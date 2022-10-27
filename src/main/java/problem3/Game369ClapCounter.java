package problem3;

public class Game369ClapCounter {
    private static final int LOWER_BOUNDS = 1;
    private static final int UPPER_BOUNDS = 10000;
    private static final String ERR_BOUNDS_ERROR = "입력 숫자는 1 이상 10000 이하입니다.";

    public static int countFromOneTo(int number) {
        validateBounds(number);
        return 0;
    }

    private static void validateBounds(int number) {
        if (number < LOWER_BOUNDS || number > UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_BOUNDS_ERROR);
    }
}

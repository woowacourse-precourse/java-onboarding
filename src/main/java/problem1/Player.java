package problem1;

import java.util.List;

public class Player {

    public static final int INIT_SUM_VALUE = 0;
    public static final int DIVIDE_CRITERION = 10;
    public static final int NUMBER_LOOP_CRITERION = 0;
    public static final int INIT_MULTIPLE_VALUE = 1;

    public Player(List<Integer> list) {
    }

    public int addDigitNumber(int number) {
        int sum = INIT_SUM_VALUE;
        while (number != NUMBER_LOOP_CRITERION) {
            sum += number % DIVIDE_CRITERION;
            number /= DIVIDE_CRITERION;
        }

        return sum;
    }

    public int multipleDigitNumber(int number) {
        int result = INIT_MULTIPLE_VALUE;
        while (number != NUMBER_LOOP_CRITERION) {
            result *= number % DIVIDE_CRITERION;
            number /= DIVIDE_CRITERION;
        }

        return result;
    }
}

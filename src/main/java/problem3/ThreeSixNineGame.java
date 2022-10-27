package problem3;

public class ThreeSixNineGame {

    private static final int DIVISION_CRITERION = 10;
    private static final int ROOF_CRITERION = 0;
    private static final int MULTIPLE_OF_THREE = 3;
    private static final int MULTIPLE_CRITERION = 0;
    private static int INIT_COUNT_ZERO = 0;

    public static int isThreeSixNineNumber(int number) {
        int totalCount = INIT_COUNT_ZERO;

        while (number != ROOF_CRITERION) {
            totalCount += countThreeSixNine(number);
            number /= DIVISION_CRITERION;
        }

        return totalCount;
    }

    private static int countThreeSixNine(int number) {
        int count = INIT_COUNT_ZERO;

        if (isThreeSixNineDigitNumber(number % DIVISION_CRITERION)) {
            count++;
        }
        return count;
    }

    private static boolean isThreeSixNineDigitNumber(int number) {
        return number % MULTIPLE_OF_THREE == MULTIPLE_CRITERION
                && number != MULTIPLE_CRITERION;
    }

}

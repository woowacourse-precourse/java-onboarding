package problem3;

public class ThreeSixNineGame {

    private static final int DIVISION_CRITERION = 10;
    private static final int ROOF_CRITERION = 0;
    private static final int MULTIPLE_OF_THREE = 3;
    private static final int MULTIPLE_CRITERION = 0;
    public static final int START_NUMBER = 1;
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

    public static int playGame(int number) {
        int answer = INIT_COUNT_ZERO;

        for (int i = START_NUMBER; i <= number; i++) {
            answer += isThreeSixNineNumber(i);
        }
        return answer;
    }
}

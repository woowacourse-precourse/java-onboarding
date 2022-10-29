package onboarding;

public class Problem3 {

    private static final int INT_VARIABLE_INIT_VALUE = 0;
    private static final int CLAPPING_NUMBER1 = 3;
    private static final int CLAPPING_NUMBER2 = 6;
    private static final int CLAPPING_NUMBER3 = 9;
    private static final int RANGE_START_NUMBER = 1;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 10000;
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] : ";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "숫자는 1이상 10,000이하의 자연수만 가능합니다.";

    public static int solution(int number) {
        int answer = INT_VARIABLE_INIT_VALUE;
        validateNumber(number);
        answer = getRangeNumberClappingCount(number);
        return answer;
    }

    private static int getOneNumberClappingCount(int number) {
        int clappingCount = INT_VARIABLE_INIT_VALUE;
        while (number != 0) {
            if (number % 10 == CLAPPING_NUMBER1 || number % 10 == CLAPPING_NUMBER2 || number % 10 == CLAPPING_NUMBER3) {
                clappingCount += 1;
            }
            number /= 10;
        }
        return clappingCount;
    }

    private static int getRangeNumberClappingCount(int rangeEndNumber) {
        int rangeNumberClappingCount = INT_VARIABLE_INIT_VALUE;
        for (int rangeIncreaseNumber = RANGE_START_NUMBER; rangeIncreaseNumber <= rangeEndNumber; rangeIncreaseNumber++) {
            rangeNumberClappingCount += getOneNumberClappingCount(rangeIncreaseNumber);
        }
        return rangeNumberClappingCount;
    }

    private static void validateNumber(int number) {
        if(!validateNumberRange(number)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_PREFIX + NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean validateNumberRange(int number) {
        return (number >= MIN_NUMBER_RANGE && number <= MAX_NUMBER_RANGE);
    }
}
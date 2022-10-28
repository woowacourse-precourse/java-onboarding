package onboarding;

public class Problem3 {

    private static final int INT_VARIABLE_INIT_VALUE = 0;
    private static final int CLAPPING_NUMBER1 = 3;
    private static final int CLAPPING_NUMBER2 = 6;
    private static final int CLAPPING_NUMBER3 = 9;
    private static final int RANGE_START_NUMBER = 1;

    public static int solution(int number) {
        int answer = INT_VARIABLE_INIT_VALUE;
        answer = getRangeNumberClappingCount(number);
        return answer;
    }

    public static int getOneNumberClappingCount(int number) {
        int clappingCount = INT_VARIABLE_INIT_VALUE;
        while(number != 0) {
            if(number % 10 == CLAPPING_NUMBER1 || number % 10 == CLAPPING_NUMBER2 || number % 10 == CLAPPING_NUMBER3) {
                clappingCount += 1;
            }
            number /= 10;
        }
        return clappingCount;
    }

    public static int getRangeNumberClappingCount(int rangeEndNumber) {
        int rangeNumberClappingCount = INT_VARIABLE_INIT_VALUE;
        for(int rangeIncreaseNumber = RANGE_START_NUMBER; rangeIncreaseNumber <= rangeEndNumber; rangeIncreaseNumber++) {
            rangeNumberClappingCount += getOneNumberClappingCount(rangeIncreaseNumber);
        }
        return rangeNumberClappingCount;
    }
}

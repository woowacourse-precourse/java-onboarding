package onboarding;

public class Problem3 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 10000;
    static final char THREE_CHAR = '3';
    static final char SIX_CHAR = '6';
    static final char NINE_CHAR = '9';
    static final int ERROR = -1;

    public static int solution(int number) {
        int answer = 0;

        if (!isValidInput(number)) {
            answer = ERROR;
            return answer;
        }
        answer = sumMultipleOfThree(number);
        return answer;
    }

    private static int sumMultipleOfThree(int number) {
        int sumMultipleOfThree = 0;

        for (int i = 1; i <= number; i++) {
            sumMultipleOfThree += countMultipleOfThree(i);
        }
        return sumMultipleOfThree;
    }

    private static int countMultipleOfThree(int number) {
        String numberToString = String.valueOf(number);
        int cnt = 0;
        char numChar;

        for (int i = 0; i < numberToString.length(); i++) {
            numChar = numberToString.charAt(i);
            if (isMultipleOfThreeChar(numChar)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isMultipleOfThreeChar(char numChar) {
        return numChar == THREE_CHAR || numChar == SIX_CHAR || numChar == NINE_CHAR;
    }

    private static boolean isValidInput(int number) {
        return isValidRange(number);
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_LENGTH && number <= MAX_LENGTH;
    }
}

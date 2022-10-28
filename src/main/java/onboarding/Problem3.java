package onboarding;

public class Problem3 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 10000;
    static final char THREE_CHAR = '3';
    static final char SIX_CHAR = '6';
    static final char NINE_CHAR = '9';

    public static int solution(int number) {
        int answer = 0;

        if (!isValidInput(number)) {
            answer = -1;
            return answer;
        }
        answer = sumMultipleOfThree(number);
        return answer;
    }

    private static int sumMultipleOfThree(int number) {
        int sumMultipleOfThree = 0;
        String numberToString;

        for (int i = 1; i <= number; i++) {
            numberToString = String.valueOf(i);
            sumMultipleOfThree += countMultipleOfThree(numberToString);
        }
        return sumMultipleOfThree;
    }

    private static int countMultipleOfThree(String numberToString) {
        int cnt = 0;
        char numchar;

        for (int i = 0; i < numberToString.length(); i++) {
            numchar = numberToString.charAt(i);
            if (numchar == THREE_CHAR || numchar == SIX_CHAR || numchar == NINE_CHAR) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isValidInput(int number) {
        return isValidRange(number);
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_LENGTH && number <= MAX_LENGTH;
    }
}

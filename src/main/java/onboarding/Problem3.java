package onboarding;

public class Problem3 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 10000;
    public static int solution(int number) {
        int answer = 0;

        if (!isValidInput(number)) {
            answer = -1;
            return answer;
        }

        return answer;
    }

    private static boolean isValidInput(int number) {
        return isValidRange(number);
    }

    private static boolean isValidRange(int number) {
        return number >= MIN_LENGTH && number <= MAX_LENGTH;
    }
}

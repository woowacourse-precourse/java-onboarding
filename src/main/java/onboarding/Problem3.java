package onboarding;

public class Problem3 {

    private final static int ERROR = -1;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 10000;

    public static int solution(int number) {
        int answer;

        if (exception(number)) {
            return ERROR;
        }

        answer = sumCount369(number);

        return answer;
    }

    private static boolean exception(int number) {
        return MIN_NUMBER > number || number > MAX_NUMBER;
    }

    private static int sumCount369(int number) {
        String stringNumber;
        int result = 0;

        for (int i = 1; i <= number; i++) {
            stringNumber = Integer.toString(i);
            result += count369(stringNumber);
        }
        return result;
    }

    private static int count369(String str) {
        int result = 0;
        final char[] COMPARE_NUMBER = {'3', '6', '9'};

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            result += str.chars()
                .filter(c -> c == COMPARE_NUMBER[finalI]).count();
        }

        return result;
    }


}

package onboarding;

public class Problem3 {

    public static final String PLEASE_ENTER_RIGHT_NUMBER = "범위 내의 숫자를 입력해주세요";
    public static final int MIN = 1;
    public static final int MAX = 10000;

    public static int solution(int number) {
        validateNumber(number);

        int clap = 0;
        for (int i = 1; i <= number; i++) {
            String currentNum = String.valueOf(i);

            for (int j = 0; j < currentNum.length(); j++) {
                char digit = currentNum.charAt(j);

                if (digit == '3' || digit == '6' || digit == '9') {
                    clap++;
                }
            }
        }

        return clap;
    }

    private static void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(PLEASE_ENTER_RIGHT_NUMBER);
        }
    }
}

package onboarding;

public class Problem3 {
    public static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        try {
            validateRange(number);
        } catch (IllegalArgumentException e) {
            return 0;
        }

        return 0;
    }

    public static void validateRange(int number) {
        if (number < 1 || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 범위 내의 숫자입니다.");
        }
    }
}

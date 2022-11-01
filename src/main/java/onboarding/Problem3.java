package onboarding;

public class Problem3 {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10000;

    public static int solution(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("유효한 숫자의 범위가 아닙니다. (1 ~ 10000)");
        }

        return play369Game(number);
    }

    private static int play369Game(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += get369Count(i);
        }

        return answer;
    }

    private static int get369Count(int num) {
        int answer = 0;
        while (num > 0) {
            if (is369(num % 10)) {
                answer++;
            }

            num /= 10;
        }
        return answer;
    }

    private static boolean is369(int n) {
        return n == 3 || n == 6 || n == 9;
    }

    private static boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}

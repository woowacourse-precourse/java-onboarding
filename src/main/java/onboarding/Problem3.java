package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getResult(number);
    }

    private static int getResult(int number) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += checkAllDigit(i);
        }
        return result;
    }

    private static int checkAllDigit(int num) {
        int sum = 0;
        while (num != 0) {
            if (is369(num % 10)) {
                sum += 1;
            }
            num /= 10;
        }
        return sum;
    }

    private static boolean is369(int n) {
        return n != 0 && (n % 3) == 0;
    }
}

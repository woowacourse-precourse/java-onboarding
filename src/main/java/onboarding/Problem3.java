package onboarding;

public class Problem3 {
    static int result;

    public static int solution(int number) {
        result = 0;
        for (int num = 1; num <= number; num++) {
            check369(num);
        }

        return result;
    }

    private static void check369(int num) {
        int remainder;
        while (num != 0) {
            remainder = num % 10;
            if (remainder != 0 && remainder % 3 == 0) {
                result += 1;
            }
            num = num / 10;
        }
    }
}

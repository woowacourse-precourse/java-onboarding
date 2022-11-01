package onboarding;

public class Problem3 {

    private static int clapCount;
    public static int solution(int number) {
        clapCount = 0;

        for (int i = 1; i <= number; i++) {
            game369(i);
        }

        return clapCount;
    }

    private static void game369(int number) {
        if (number <= 0) {
            return ;
        }

        if (is369(number % 10)) {
            clapCount++;
        }

        game369(number / 10);
    }

    private static boolean is369(int n) {
        if (n == 0) {
            return false;
        }
        return n % 3 == 0;
    }
}

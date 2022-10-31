package onboarding;

public class Problem3 {
    public static int solution(int number) {

        return getClapCount(number);
    }

    private static int getClapCount(int number) {
        int clapCount = 0;

        for (int i = 1; i <= number; i++) {
            clapCount += get369Count(i);
        }

        return clapCount;
    }

    private static int get369Count(int number) {
        int count = 0;

        while (number > 0) {
            if (is369(number % 10)) {
                count++;
            }

            number /= 10;
        }

        return count;
    }

    private static boolean is369(int number) {
        return number == 3 || number == 6 || number == 9;
    }

}

package onboarding;

public class Problem3 {
    private static int clap(int number) {
        int count = 0;
        while (number > 0) {
            int digit = (number % 10);
            if (digit != 0 && digit % 3 == 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    private static int countClap(int number) {
        int count = 0;
        for (int i = number; i > 0; i--) {
            count += clap(i);
        }
        return count;
    }

    public static int solution(int number) {
        return countClap(number);
    }
}

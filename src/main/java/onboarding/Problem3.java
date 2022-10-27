package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int numberOfClap = 0;
        for (int i = 0; i <= number; i++) {
            numberOfClap += count369(i);
        }
        return numberOfClap;
    }

    private static int check369(int digit) {
        if (digit == 3) return 1;
        if (digit == 6) return 1;
        if (digit == 9) return 1;

        return 0;
    }

    private static int count369(int number) {
        int numberOf369 = 0;
        int digit = 0;
        while (number > 0) {
            digit = number % 10;
            numberOf369 += check369(digit);
            number /= 10;
        }
        return numberOf369;
    }
}

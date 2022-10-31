package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getTotalClapCount(number);
    }

    private static int getTotalClapCount(int number) {
        int totalClapCount = 0;
        for (int i = 1; i <= number; i++) {
            totalClapCount += getClapCount(i);
        }
        return totalClapCount;
    }

    private static int getClapCount(int number) {
        int clapCount = 0;
        while (number > 0) {
            if (isMultipleOfThree(number % 10)) clapCount++;
            number /= 10;
        }
        return clapCount;
    }

    private static boolean isMultipleOfThree(int digit) {
        return digit != 0 && digit % 3 == 0;
    }
}

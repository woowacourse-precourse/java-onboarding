package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getTotalClapCount(number);
    }

    private static int getTotalClapCount(int maxNumber) {
        int totalCount = 0;
        for (int number = 1; number <= maxNumber; number++) {
            totalCount += getClapCount(number);
        }
        return totalCount;
    }

    private static int getClapCount(int number) {
        int count = 0;
        while (isNotZero(number)) {
            int digitNumber = number % 10;
            if (isThree(digitNumber) || isSix(digitNumber) || isNine(digitNumber)) {
                count++;
            }
            number /= 10;
        }
        return count;
    }

    private static boolean isNotZero(int number) {
        return number != 0;
    }

    private static boolean isThree(int digitNumber) {
        return digitNumber == 3;
    }

    private static boolean isSix(int digitNumber) {
        return digitNumber == 6;
    }

    private static boolean isNine(int digitNumber) {
        return digitNumber == 9;
    }
}

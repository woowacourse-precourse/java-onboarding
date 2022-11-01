package onboarding;

import java.util.List;

public class Problem3 {

    private static final List<Integer> CLAP_VALUES = List.of(3, 6, 9);
    private static final int MIN_NUMBER = 1;
    private static final int CIPHER_OF_TEN = 10;

    public static int solution(int number) {
        return findAllClapCounts(number);
    }

    private static int findAllClapCounts(int number) {
        int totalClapCount = 0;
        for (int currNumber = MIN_NUMBER; currNumber <= number; currNumber++) {
            totalClapCount += findClapCount(currNumber);
        }
        return totalClapCount;
    }

    private static int findClapCount(int number) {
        int clapCount = 0;
        while (number > 0) {
            clapCount += detectAnyClapValue(number);
            number /= CIPHER_OF_TEN;
        }
        return clapCount;
    }

    private static int detectAnyClapValue(int number) {
        if (checkClapValue(number)) {
            return 1;
        }
        return 0;
    }

    private static boolean checkClapValue(int number) {
        int cipherNumber = findCipherNumber(number);
        return CLAP_VALUES.contains(cipherNumber);
    }

    private static int findCipherNumber(int number) {
        return number % CIPHER_OF_TEN;
    }
}

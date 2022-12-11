package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return calculateTotalClaps(number);
    }

    private static int calculateTotalClaps(int number) {
        return IntStream.rangeClosed(1,number).map(Problem3::calculateCurrentNumberClaps).sum();
    }

    private static int calculateCurrentNumberClaps(int currentNumber) {
        int originalLength = String.valueOf(currentNumber).length();
        return originalLength - countTargets(currentNumber).length();
    }

    private static String countTargets(int currentNumber) {
        return String.valueOf(currentNumber).replaceAll("[369]", "");
    }

}

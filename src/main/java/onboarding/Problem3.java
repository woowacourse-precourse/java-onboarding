package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return calculateTotalClaps(number);
    }

    private static int calculateTotalClaps(int number) {
        int totalClaps = 0;
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            totalClaps += calculateCurrentNumberClaps(currentNumber);
        }
        return totalClaps;
    }

    private static int calculateCurrentNumberClaps(int currentNumber) {
        int originalLength = String.valueOf(currentNumber).length();
        return originalLength - String.valueOf(currentNumber).replaceAll("[369]", "").length();
    }

}

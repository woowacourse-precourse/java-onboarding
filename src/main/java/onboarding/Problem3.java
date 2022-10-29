package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int totalCount = 0;

        for (int index = 1 ; index <= number ; index++) {
            String currentNumber = String.valueOf(index);
            totalCount += getSamYukGuCount(currentNumber);
        }

        return totalCount;
    }

    private static int getSamYukGuCount(String currentNumber) {
        int count = 0;

        for (int digitIndex = 0 ; digitIndex < currentNumber.length() ; digitIndex++) {
            if (isSamYukGu(currentNumber.charAt(digitIndex))) {
                count++;
            }
        }

        return count;
    }

    private static boolean isSamYukGu(char digit) {
        return digit == '3' || digit == '6' || digit == '9';
    }
}

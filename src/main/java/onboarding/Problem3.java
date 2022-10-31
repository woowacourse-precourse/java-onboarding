package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countAllNumbers(number);
    }

    private static String intToString(int number) {
        return Integer.toString(number);
    }

    private static boolean containsNumber(String StringNumber, String charNumber) {
        return StringNumber.contains(charNumber);
    }

    private static long countNumber(String StringNumber, char charNumber) {
        return StringNumber.chars()
                .filter(c -> c == charNumber)
                .count();
    }

    private static int countAllNumber(String stringNumber) {
        int count = 0;

        if (containsNumber(stringNumber, "3")) {
            count += countNumber(stringNumber, '3');
        } else if (containsNumber(stringNumber, "6")) {
            count += countNumber(stringNumber, '6');
        } else if (containsNumber(stringNumber, "9")) {
            count += countNumber(stringNumber, '9');
        }

        return count;
    }

    private static int countAllNumbers(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            String stringNumber = intToString(i);
            count += countAllNumber(stringNumber);
        }

        return count;
    }
}

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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
}

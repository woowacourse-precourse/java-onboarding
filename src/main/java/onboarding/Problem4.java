package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean isAlphabet(char target) {
        return isUpperCase(target) || isLowerCase(target);
    }

    private static boolean isUpperCase(char target) {
        return 'A' <= target && target <= 'Z';
    }

    private static boolean isLowerCase(char target) {
        return 'a' <= target && target <= 'z';
    }
}

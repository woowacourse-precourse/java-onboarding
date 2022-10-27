package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char)(standardA + (standardZ - target));
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

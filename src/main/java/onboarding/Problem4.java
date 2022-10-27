package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String calculateWord(String word) {
        char[] chars = word.toCharArray();
        char standardA;
        char standardZ;

        for (int i = 0; i < chars.length; i++) {
            if (!isAlphabet(chars[i])) {
                continue;
            }
            standardA = 'a';
            standardZ = 'z';
            if (isUpperCase(chars[i])) {
                standardA = 'A';
                standardZ = 'Z';
            }
            chars[i] = calculateCharacter(standardA, standardZ, chars[i]);
        }
        return String.valueOf(chars);
    }

    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char) (standardA + (standardZ - target));
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

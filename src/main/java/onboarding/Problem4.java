package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (!isValidate(word)) {
            return "error";
        }
        return convertString(word);
    }

    /**
     * word의 길이를 검증하는 기능
     */
    public static boolean isValidate(String word) {
        int length = word.length();
        return (length > 0 && length < 1001);
    }

    public static String convertString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] toCharArray = word.toCharArray();
        for (char ch : toCharArray) {
            if (isAlpha(ch)) {
                sb.append(convertAlpha(ch));
                continue;
            }
            sb.append(ch);
        }
        return String.valueOf(sb);
    }

    public static char convertAlpha(char alpha) {
        int index = getIndexOfAlpha(alpha);
        int covert = 27 - 2 * index;
        return (char) (alpha + covert);
    }

    public static int getIndexOfAlpha(char alpha) {
        char upperCase = Character.toUpperCase(alpha);
        return upperCase - 'A' + 1;
    }

    public static boolean isAlpha(char ch) {
        return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }
}

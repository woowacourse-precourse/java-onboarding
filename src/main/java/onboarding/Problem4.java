package onboarding;

public class Problem4 {
    public static char convertChar(char ch, boolean isUppercase) {
        if (isUppercase) {
            return (char) (155 - (int) ch);
        } else {
            return (char) (219 - (int) ch);
        }
    }

    public static String solution(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                chars[i] = convertChar(ch, true);
            } else if (ch >= 'a' && ch <= 'z') {
                chars[i] = convertChar(ch, false);
            }
        }
        return String.valueOf(chars);
    }
}

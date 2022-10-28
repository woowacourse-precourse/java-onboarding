package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isAlphabetic(ch)) {
                chars[i] = reverse(ch);
            }
        }
        return String.valueOf(chars);
    }

    private static char reverse(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) (122 - ch + 97);
        } else {
            return (char) (90 - ch + 65);
        }
    }
}

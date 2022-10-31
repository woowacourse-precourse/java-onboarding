package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            sb.append(Character.isAlphabetic(ch) ? reverseChar(ch) : ch);
        }

        return sb.toString();
    }

    public static char reverseChar(char ch) {
        if (Character.isUpperCase(ch))
            return (char)('A' + 25 - (ch - 'A'));
        else
            return (char)('a' + 25 - (ch - 'a'));
    }
}

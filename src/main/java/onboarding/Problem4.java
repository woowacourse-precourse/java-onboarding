package onboarding;

public class Problem4 {

    public static char converAlpha(char ch) {
        if (ch < 65) {
            return ch;
        } else if (ch < 97) {
            return (char) (2 * 65 + 25 - (int) ch);
        } else {
            return (char) (2 * 97 + 25 - (int) ch);
        }
    }

    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(converAlpha(word.charAt(i)));
        }
        return stringBuilder.toString();
    }
}

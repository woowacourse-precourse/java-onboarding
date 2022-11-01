package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char src = word.charAt(i);
            char result = (src == ' ') ? src : getSymmetricAlphabet(src);
            builder.append(result);
        }
        return builder.toString();
    }

    private static boolean isLowerCase(char ch) {
        return (ch >= 97 && ch <= 122) ? true : false;
    }

    private static char getSymmetricAlphabet(char ch) {
        int startValue = 65, endValue = 90;
        if (isLowerCase(ch)) {
            startValue = 97;
            endValue = 122;
        }
        return (char) (endValue - (ch - startValue));
    }
}

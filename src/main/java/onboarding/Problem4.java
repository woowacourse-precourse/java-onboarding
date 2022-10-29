package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char src = word.charAt(i);
            // 해당 문자가 공백문자라면 변환을 하지 않는다.
            char result = (src == ' ') ? src : getSymmetricAlphabet(src);
            builder.append(result);
        }
        return builder.toString();
    }

    private static boolean isLowerCase(char ch) {
        return (ch >= 97 && ch <= 122) ? true : false;
    }

    private static char getSymmetricAlphabet(char ch) {
        int startValue = 65;
        int endValue = 90;
        // 주어진 문자가 소문자라면 기준 값을 변경한다.
        if (isLowerCase(ch)) {
            startValue = 97;
            endValue = 122;
        }
        return (char) (endValue - (ch - startValue));
    }
}

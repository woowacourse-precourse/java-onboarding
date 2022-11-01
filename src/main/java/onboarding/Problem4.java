package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // word 길이 예외처리
        if (word.length() < 1 || word.length() > 1000)
            try {
                throw new Exception("Word's length must be 1 and 1000");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        StringBuilder answer = new StringBuilder();
        for (int idx = 0; idx < word.length(); idx++) {
            answer.append(transformChar(word.charAt(idx)));
        }
        return answer.toString();
    }

    public static char transformChar(char c) {
        if (isUpper(c))
            return transformUpper(c);
        else if (isLower(c))
            return transformLower(c);
        return c;
    }

    public static char transformUpper(char upperChar) {
        return (char) (155 - (int) upperChar);
    }

    public static char transformLower(char lowerChar) {
        return (char) (219 - (int) lowerChar);
    }

    public static boolean isUpper(char c) {
        return 65 <= (int) c && (int) c <= 90;
    }

    public static boolean isLower(char c) {
        return 97 <= (int) c && (int) c <= 122;
    }

    public static boolean isAlpha(char c) {
        return isUpper(c) || isLower(c);
    }
}

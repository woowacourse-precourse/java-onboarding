package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getConvertedString(word);
    }

    private static String getConvertedString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            sb.append(getConvertedChar(c));
        }
        return sb.toString();
    }

    private static char getConvertedChar(int c) {
        // 대문자인 경우
        if (c >= 65 && c <= 90) {
            return getConvertedUpperCase(c);
        }
        // 소문자인 경우
        if (c >= 97 && c <= 122) {

        }
    }

    private static char getConvertedUpperCase(int c) {
        return (char)(155 - c);
    }
}

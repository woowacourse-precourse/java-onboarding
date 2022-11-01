package onboarding;

public class Problem4 {

    /**
     * solution 메소드
     * StringBuilder를 이용하여 결과 문자열을 저장, 도출
     */
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            verifyChar(word, sb, i);
        }

        return sb.toString();
    }

    /**
     * 대소문자, 혹은 그 이외 문자 판별 메소드
     */
    private static void verifyChar(String word, StringBuilder sb, int i) {
        Character c = word.charAt(i);

        if (isUpper(c)) {
            sb.append(upperToLower(c));
        } else if (isLower(c)) {
            sb.append(lowerToUpper(c));
        } else {
            sb.append(c);
        }
    }

    /**
     * 대문자 판별 메소드
     */
    private static boolean isUpper(char word) {
        if ((int) word >= 65 && (int) word <= 90) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 소문자 판별 메소드
     */
    private static boolean isLower(char word) {
        if ((int) word >= 97 && (int) word <= 122) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 대문자에서 소문자 변환 메소드
     */
    private static char upperToLower(char word) {
        return (char)(90 - ((int) word - 65));
    }

    /**
     * 소문자에서 대문자 변환 메소드
     */
    private static char lowerToUpper(char word) {
        return (char)(122 - ((int) word - 97));
    }
}

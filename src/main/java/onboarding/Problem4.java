package onboarding;

public class Problem4 {
    /**
     * 문자열을 청개구리 변환 한 결과를 리턴합니다.
     */
    public static String solution(String word) {
        StringBuilder s = new StringBuilder();

        for (Character c: word.toCharArray()) {
            s.append(invertedChar(c));
        }

        return s.toString();
    }

    /**
     * 문자가 앞에서부터 i번째의 영문자라면, 뒤에서부터 i번째인 영문자를 리턴합니다.
     * 문자가 영문자가 아니라면, 문자 그대로를 리턴합니다.
     * <p>
     * 문자가 대문자라면 대문자를 리턴하고, 소문자라면 소문자를 리턴합니다.
     */
    private static Character invertedChar(Character c) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + 'z' - c);
        }
        if (Character.isUpperCase(c)) {
            return (char) ('A' + 'Z' - c);
        }
        return c;
    }
}

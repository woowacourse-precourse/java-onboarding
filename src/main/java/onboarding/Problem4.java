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

    /**
     * 요구사항에 맞게 문자 ch를 변환하여 변환된 문자를 리턴
     */
    public static char reverseChar(char ch) {
        if (Character.isUpperCase(ch))
            return (char)('A' + 25 - (ch - 'A'));
        else
            return (char)('a' + 25 - (ch - 'a'));
    }
}

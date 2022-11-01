package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            appendChar(output, word.charAt(i));
        }
        return output.toString();
    }


    // 문자를 규칙에 따라 바꾸고, StringBuilder에 append하는 메서드
    private static void appendChar(StringBuilder output, char c) {
        if ('A' <= c && c <= 'Z') {
            output.append((char)('Z' - c + 'A'));
        } else if ('a' <= c && c <= 'z') {
            output.append((char)('z' - c + 'a'));
        } else {
            output.append(c);
        }
    }
}
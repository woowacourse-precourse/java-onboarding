package onboarding;

public class Problem4 {
    public static char convertChar(char ch) {
        // 알파벳에 해당하는 문자를 주어진 표에 따라 반환합니다.
        if ('a' <= ch && ch <= 'z')
            ch = (char) ('z' - ch + 'a');

        else if ('A' <= ch && ch <= 'Z')
            ch = (char) ('Z' - ch + 'A');

        // 알파벳이 아니면 그대로 반환합니다.
        return ch;
    }

    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(convertChar(word.charAt(i)));
        }

        answer = sb.toString();
        return answer;
    }
}

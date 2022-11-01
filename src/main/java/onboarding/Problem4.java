package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(changeCharacter(word.charAt(i)));
        }

        answer = sb.toString();

        return answer;
    }

    // 글자 변환
    private static char changeCharacter(char ch) {
        // 대문자인 경우
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ('A' + 'Z' - ch);
        }
        // 소문자인 경우
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('a' + 'z' - ch);
        }

        return ch;
    }
}

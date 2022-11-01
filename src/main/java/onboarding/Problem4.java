package onboarding;

/**
 * 기능 목록
 * 1. 알파벳인지 확인하는 함수
 * 2. 알파벳을 변환하는 함수
 * 3. 알파벳이면 변환, 아니면 변환하지 않고 이어붙여 정답 출력
 */
public class Problem4 {
    static final char LOWER = 'a';
    static final char UPPER = 'A';

    static boolean isAlphabet(char ch) {
        return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
    }

    static char changeCase(char ch) {
        char seq = Character.isUpperCase(ch) ? UPPER : LOWER;
        return (char) (seq + Math.abs((ch - seq + 1) - 26));
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char ch: word.toCharArray()) {
            if (!isAlphabet(ch)) {
                answer.append(ch);
                continue;
            }
            answer.append(changeCase(ch));
        }
        return answer.toString();
    }
}

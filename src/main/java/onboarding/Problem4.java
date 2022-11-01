package onboarding;

/**
 * 구현 순서
 * 1. word의 각 글자가 알파벳인지 확인
 * 2. 알파벳을 반대로 변환
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = encrypt(word);
        return answer;
    }

    private static String encrypt(String plain) {
        StringBuilder cypher = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i);
            if (c >= 'A' && c <= 'Z')
                cypher.append((char) ('Z' - (c - 'A')));
            else if (c >= 'a' && c <= 'z')
                cypher.append((char) ('z' - (c - 'a')));
            else
                cypher.append(c);
        }

        return cypher.toString();
    }
}

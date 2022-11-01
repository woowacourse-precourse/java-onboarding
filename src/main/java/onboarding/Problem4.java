package onboarding;

/**
 * 기능 목록
 * 1. 인자로 전달된 문자열을 순회
 * 2. 현재 문자가 알파벳 문자인지 검증
 * 3. 대문자인지 검증
 * 4. 청개구리 규칙으로 반환된 문자 반환
 */
public class Problem4 {
    /* 시간복잡도 O(N) N: 문자열 word의 길이*/
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            sb.append(updateByWordDictRule(c));
        }
        return sb.toString();
    }

    static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    static char updateByWordDictRule(char c) {
        int base = 0, offset = 0;
        if (isUpperCase(c)) {
            base = 'A';
            offset = Math.abs('Z' - c);
        } else {
            base = 'a';
            offset = Math.abs('z' - c);
        }
        return (char) (base + offset);
    }
}

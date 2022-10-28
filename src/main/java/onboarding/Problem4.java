package onboarding;

/*
    기능 명세
    1. convert(String word) : 단어를 입력받아서 청개구리 사전대로 바꾸는 함수
 */
public class Problem4 {
    public static String solution(String word) {
        return convert(word);
    }

    public static String convert(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result.append((char) ('z' - c + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                result.append((char) ('Z' - c + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

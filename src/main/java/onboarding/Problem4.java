package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            answer = answer + transChar(word.charAt(i));
        }
        return answer;
    }

    // 한 문자에 대해 청개구리 사전을 적용
    public static char transChar(char ch) {
        int vector = getVector(ch);
        if (vector == -1) return ch;

        return (char) (ch + (25 - 2 * vector));
    }

    // 대소문자 상관없이 몇 번째 알파벳인지 반환
    private static int getVector(char ch) {
        if ('a' <= ch && ch <= 'z')
            return ch - 'a';
        else if ('A' <= ch && ch <= 'Z')
            return ch - 'A';
        return -1;   // 알파벳이 아님
    }
}

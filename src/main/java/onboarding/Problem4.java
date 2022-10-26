package onboarding;

/*
1. 알파벳 초기화
2. 알파벳 인덱스 찾기
3. 반전 알파벳 인덱스 찾아 변환하기
 */

public class Problem4 {

    private static char[] initializeReverseAlphabet(char[] alphabet) {
        char[] reverseAlphabet = new char[26];
        for (int i = 0; i < alphabet.length; i ++) {
            reverseAlphabet[i] = alphabet[alphabet.length - i - 1];
        }
        return reverseAlphabet;
    }

    private static char[] initializeAlphabet() {
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i ++) {
            alphabet[i] = (char) ('A'+ i);
        }
        return alphabet;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

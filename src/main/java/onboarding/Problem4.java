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

    private static int findAlphabetIndex(char[] alpabet, char tmp) {
        int result = -1;

        if (Character.isLowerCase(tmp)) {
            tmp -= 32;
        }
        for (int i = 0; i < alpabet.length; i ++) {
            if (alpabet[i] == tmp) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static String convertAlphabet(String word) {
        String tmp = "";
        int index = -1;
        char[] alphabet = initializeAlphabet();
        char[] reverseAlphabet = initializeReverseAlphabet(alphabet);

        for (int i = 0; i < word.length(); i ++) {
            index = findAlphabetIndex(alphabet, word.charAt(i));
        }
        return tmp;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}

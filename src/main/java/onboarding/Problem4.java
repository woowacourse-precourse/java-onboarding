package onboarding;

import java.util.Arrays;

/**
 * 기능 목록
 * 1. 청개구리 사전 초기화 함수
 * 2. 청개구리 사전 기반 단어 변환 함수
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] reverseDictionary = new char[26];

        initReverseDictionary(reverseDictionary);

        return answer;
    }

    public static void initReverseDictionary(char[] reverseDictionary) {
        char reverseAlphabet = 'Z';
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            int index = alphabet - 'A';

            reverseDictionary[index] = reverseAlphabet;

            reverseAlphabet--;
        }
    }
}

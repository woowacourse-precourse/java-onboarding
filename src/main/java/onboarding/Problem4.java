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

        char[] words = word.toCharArray();

        reverseWords(words, reverseDictionary);

        answer = String.valueOf(words);
        return answer;
    }

    public static boolean checkLowerCase(char word){
        return word > 'Z';
    }

    public static void reverseWords(char[] words, char[] reverseDictionary) {
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            if(words[i] == ' '){
                continue;
            }

            boolean isLowerCase = false;

            if(checkLowerCase(words[i])){
                isLowerCase = true;
            }

            if(isLowerCase){
                // 소문자를 대문자로 변환 후 'A'를 빼주기
                index = words[i] - 32 - 'A';
            } else if(!isLowerCase){
                index = words[i] - 'A';
            }

            char reverseWord = reverseDictionary[index];

            if(isLowerCase){
                reverseWord = (char) (reverseWord + 32);
            }
            words[i] = reverseWord;
        }
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

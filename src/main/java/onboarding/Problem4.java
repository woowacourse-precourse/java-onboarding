package onboarding;


import java.util.ArrayList;
import java.util.Arrays;

public class Problem4 {
    /** 기능 명세
     * 1. 주어진 문자와 대응되는 청개구리 문자를 찾아 변환하기
     * 2. 예외처리
     *    - 알파벳 외의 문자인지 확인한다.
     */

    public static String makeOpposite(String word) {
        char[] wordToArr = word.toCharArray();
        String result = "";
        for (char letter : wordToArr) {
            if (!Character.isAlphabetic(letter)) { result += letter; }            // 알파벳이 아니면 변환하지 않음
            else                                 { result += converter(letter); } // 알파벳이면 변환 진행
        }
        return result;
    }

    public static char converter(char letter) {   // 사전에 따라 문자를 변환해주는 함수
        ArrayList<Character> dictionary = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X' , 'Y', 'Z'));
        if (Character.isLowerCase(letter)) { letter = Character.toLowerCase(dictionary.get(25 - dictionary.indexOf(Character.toUpperCase(letter)))); }
        else                               { letter = dictionary.get(25 - dictionary.indexOf(letter)); }
        return letter;
    }

    public static String solution(String word) {
        String answer = makeOpposite(word);
        return answer;
    }
}

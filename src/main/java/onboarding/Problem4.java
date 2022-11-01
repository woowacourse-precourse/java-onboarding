package onboarding;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 청개구리 변환 Map 선언 (대문자 , 소문자)
        Map<Character, Character> frogWordsUpper = new LinkedHashMap<>();
        Map<Character, Character> frogWordsLower = new LinkedHashMap<>();

        // Map의 값이 될 역순 알파벳 선언
        char reverseUpper = 'Z';
        char reverseLower = 'z';

        for (int i = 'A'; i <= 'Z'; i++) {
            // 청개구리화
            frogWordsUpper.put((char) i, reverseUpper--);
            frogWordsLower.put(Character.toLowerCase((char) i), reverseLower--);
        }

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            // 공백 시 공백추가 , 이외는 청개구리화
            if(now == ' '){
                answer += " ";
            }else if (90 >= now && now >= 65) {
                answer += frogWordsUpper.get(now);
            }else {
                answer += frogWordsLower.get(now);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String word = "I love you";
        solution(word);
    }
}

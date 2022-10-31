package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = ""; // 결과값

        String[] array_word; // 주어진 문자열 저장할 배열
        // 청개구리 사전
        String[] change_word = { "Z", "Y", "X", "W", "V", "U" , "T" , "S" , "R" , "Q" , "P" , "O" , "N" , "M" , "L" , "K" , "J" , "I" , "H" , "G" , "F" , "E" , "D" , "C" , "B" , "A" };

        Map<String, String> alpha = new HashMap<>();

        char[] alpabat = new char[26];

        for (int i=0; i<alpabat.length; i++) {
            alpha.put(Character.toString((char) ('A' + i)), change_word[i]);
        }

        array_word = word.split("");

        for (String c_word : array_word) { // 문자 확인
            boolean is_upp = Character.isUpperCase(c_word.charAt(0)); // 대문자 여부
            String temp_result = alpha.get(c_word.toUpperCase());

            if (temp_result == null) { // 공백 처리
                temp_result = " ";
            }
            else if (!is_upp) { // 소문자 처리
                temp_result  = temp_result.toLowerCase();
            }
            answer = answer.concat(temp_result);
        }

        return answer;
    }
}

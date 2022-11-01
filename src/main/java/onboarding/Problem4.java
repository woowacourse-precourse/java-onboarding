package onboarding;

import java.util.HashMap;
import java.util.Map;
public class Problem4 {
    public static String solution(String word) {
        String result = "";
        String[] array_word; //문자 리스트 변환위한 선언
        String[] change_word = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K",
                "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};  //변환할 알파벳 순서대로 저장
        Map<String, String> alpha = new HashMap<>();
        char[] alpabat = new char[26];

        for (int i = 0; i < alpabat.length; i++) //알파벳 for문
            alpha.put(Character.toString((char) ('A' + i)), change_word[i]);
        array_word = word.split(""); //배열에 분할된 단어 저장

        for (String c_word : array_word) {  //대소문자 구분 작업
            boolean is_upp = Character.isUpperCase(c_word.charAt(0));   
            String temp_result = alpha.get(c_word.toUpperCase());
            if (temp_result == null)
                temp_result = " ";
            else if (!is_upp)
                temp_result = temp_result.toLowerCase();
            result = result.concat(temp_result);
        }
        return result;
    }
}

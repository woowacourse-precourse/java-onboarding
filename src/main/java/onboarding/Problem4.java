package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String result = "";

        String[] array_word;// 문자를 배열에
        String[] change_word = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};//치환 할 알파벳

        Map<String, String> alpha = new HashMap<>();

        char[] alphabat = new char[26];


        for (int i = 0; i < alphabat.length; i++) {//알파벳 for문
            alpha.put(Character.toString((char) ('A' + i)), change_word[i]);//알파벳 별로 담고 치환할꺼 까지 담기
        } // 알파벳과 치환할 알파벳 넣은 사전 생성


        array_word = word.split(""); //입력받은 문자열을 한글자씩 저장하기


        for (String c_word : array_word) { // 개선된 for문. array_word에 저장된 글자를 하나씩 for문으로 가져옴.
            boolean is_upp = Character.isUpperCase(c_word.charAt(0));//대소문자 구분


            String temp_result = alpha.get(c_word.toUpperCase());
            if (temp_result == null) {//null이거나, 특수문자거나 공백일때는
                temp_result = " ";
            } else if (!is_upp) {//소문자라면
                temp_result = temp_result.toLowerCase();
            }

            result = result.concat(temp_result);


        }
        return result;
    }
}
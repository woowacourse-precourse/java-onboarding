package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] basic_word;
        // 청개구리 언어
        String[] change_word = {"Z", "Y", "X", "W", "V", "U", "T", "S",  "R", "Q", "P", "O", "N", "M", "L",
                "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};

        basic_word = word.split("");

        // 해시맵에 청개구리 언어 저장
        HashMap<String, String> convert = new HashMap<>();

        for(int i = 0; i < 26; i++ ){ // 알파벳 26개
            convert.put(String.valueOf((char) ('A' + i)), change_word[i]);
        }
        return answer;
    }
}

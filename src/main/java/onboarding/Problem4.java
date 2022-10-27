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

        boolean frog = validation(word);
        if (!frog) {
            return "";
        }

        // 해시맵에 청개구리 언어 저장
        HashMap<String, String> convert = new HashMap<>();

        for(int i = 0; i < 26; i++ ){ // 알파벳 26개
            convert.put(String.valueOf((char) ('A' + i)), change_word[i]);
        }
        for(String c : basic_word) {
            // 대문자 true, 나머지 false
            boolean isUpper = Character.isUpperCase(c.charAt(0));

            String now_value = convert.get(c.toUpperCase());
            // 알파벳 외의 문자는 변환하지 않는다.
            if (now_value == null) {
                now_value = " ";
            }
            // false인데 null이 아닐 경우 소문자로
            if (!isUpper) {
                now_value = now_value.toLowerCase();
            }
            answer = answer + now_value;
        }
        return answer;
    }

    private static boolean validation(String word) {
        // 1미만, 10000 초과
        if(word.length() < 1 || word.length() > 1000) {
            return false;
        }
        return true;
    }
}

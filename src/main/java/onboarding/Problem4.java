package onboarding;

import java.util.HashMap;

public class Problem4 {
    /**
     * 기능 목록
     * 1. map에 알파벳과 그 역순을 저장
     * 2. word를 한 글자씩 받아서 문자일 경우 대소문자를 구분하며 map으로 변환
     */
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> map = new HashMap<>();
        // 1. map에 알파벳과 그 역순을 저장
        for(int i = 0; i < 26; i++) {
            map.put((char) ('A' + i),(char) ('Z' - i));
        }

        // 2. word를 한 글자씩 받아서 문자일 경우 대소문자를 구분하며 map으로 변환
        for(int i = 0; i < word.length(); i++) {
            char append = word.charAt(i);
            if(Character.isLetter(append)) {
                if(Character.isLowerCase(append)) {
                    append = map.get(Character.toUpperCase(append));
                    append = Character.toLowerCase(append);
                } else {
                    append = map.get(append);
                }
            }
            answer += Character.toString(append);
        }
        return answer;
    }
}

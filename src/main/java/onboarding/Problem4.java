package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 딕셔너리에 청개구리 사전 넣기
        Map<Character, Character> dictionary = new HashMap<>();
        int j = (int) 'z';
        for (int i = (int) 'a'; i < ((int) 'z' + 1); i ++) {
            dictionary.put((char) i, (char) j);
            j--;
        }

        // 입력된 문자열 한 자씩 돌기
        for (int i = 0; i < word.length(); i++) {
            char present = word.charAt(i);

            // 문자가 공백이라면 그대로 answer에 추가
            if (present == ' ') {
                answer += ' ';
                continue;
            }

            // 대문자 여부 확인
            int isUpper = 0;
            if ((int) present < 97) {
                isUpper = 1;
                present = Character.toLowerCase(present);
            }
            char dicWord = dictionary.get(present);

            //대문자라면 answer에 대문자로 넣고, 아닐 경우 소문자로
            if (isUpper == 1) {
                answer += Character.toUpperCase(dicWord);
            } else {
                answer += dicWord;
            }

        }

        return answer;
    }
}

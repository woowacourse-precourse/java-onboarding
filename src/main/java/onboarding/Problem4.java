package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    /**
     * 요구사항
     * 1<= word <= 1000
     * 대문자, 소문자 구분
     *
     * 아스키 코드
     * 대문자 65~90
     * 소문자 97~122
     */
    public static String solution(String word) {
        HashMap<Integer, Integer> B_objectMapper = new HashMap<>();
        HashMap<Integer, Integer> S_objectMapper = new HashMap<>();
        String answer = "";

        for (int i = 65, j = 90; i < 91; i++, j--) {
            B_objectMapper.put(i, j);
            S_objectMapper.put((i + 32), (j + 32));
        }

        for (int i = 0; i < word.length(); i++) {
            int int_key = word.charAt(i);
            if (32 == int_key){
                answer += " ";
            }
            if (65 <= int_key) {
                if (int_key <= 90) {
                    answer += (char)(int)B_objectMapper.get(int_key);
                } else if (97 <= int_key) {
                    answer += (char)(int)S_objectMapper.get(int_key);
                } else{
                    answer = answer;
                }
            }
        }

        return answer;
    }
}

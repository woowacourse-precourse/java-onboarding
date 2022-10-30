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
        HashMap<Integer, Integer> upper_Mapper = new HashMap<>();
        HashMap<Integer, Integer> lower_Mapper = new HashMap<>();
        String answer = "";
        //대문자와 소문자 Mapper 생성
        for (int i = 65, j = 90; i < 91; i++, j--) {
            upper_Mapper.put(i, j);
            lower_Mapper.put((i + 32), (j + 32));
        }
        //문자를 받아서 Mapper 사용
        for (int i = 0; i < word.length(); i++) {
            int int_key = word.charAt(i);
            // 공백일때
            if (32 == int_key){
                answer += " ";
            }
            //대소문자일때만 처리한다.
            if (65 <= int_key) {
                if (int_key <= 90) {
                    answer += (char)(int)upper_Mapper.get(int_key);
                } else if (97 <= int_key) {
                    answer += (char)(int)lower_Mapper.get(int_key);
                } else{
                    //그 외 문자는 처리하지 않는다.
                    answer = answer;
                }
            }
        }

        return answer;
    }
}

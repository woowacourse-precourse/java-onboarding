package onboarding;

//Sol1: 해시맵을 이용한 사전 방식
//주의 사항 소문자는 소문자로 대문자는 대문자로

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
//        valid(word);
        String answer = "";
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put( (char)('a'+i), (char)('z'-i)); //개구리 사전을 만든다. 단 소문자와 대문자 둘다 만들어준다.
            map.put((char)('A'+i), (char)('Z'-i));
        }
        for(int i = 0; i < word.length(); i++){ //문자를 받아 사전에 입력하면 사전에 정의한 값이 출력되며 없을 때는 문자 그대로 반환한다.
            Character c = word.charAt(i);
            answer += map.getOrDefault(c, c);   //입력받은 문자가 사전에 없으면 그대로 추가하고 있으면 사전에 맞춰 추가한다.
        }
        return answer;
    }

    public static void valid(String w) throws Exception {
        if(w.length() < 1 || w.length() > 1000){
            throw new Exception("문자의 길이가 1이상 1000이하가 아닙니다.");
        }
    }
}

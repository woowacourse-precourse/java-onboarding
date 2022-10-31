package onboarding;

/*
 기능 요구 사항
 1. 반대 순서의 알파벳으로 바꾸기
 2. 대소문자 판단하여 대문자는 대문자 그대로, 소문자는 소문자 대로 ( Character.isUpperCase(), isLowerCase())

 */

import java.util.Map;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";
        Map<Character, Character> wordDict = new HashMap<>();

        for(int i =0; i < 26; i++){ // 문자 사전 생성
            wordDict.put((char)('a'+i), (char)('z'-i));
            wordDict.put((char)('A'+i), (char)('Z'-i));
        }


        return answer;
    }

}

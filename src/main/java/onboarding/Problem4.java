package onboarding;


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

        for (int i =0; i<word.length(); i++){ // 반대로 된 문자열 생성
            answer += wordDict.getOrDefault(word.charAt(i),word.charAt(i));
        }

        return answer;
    }

}

package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    // 기능 목록
    // 서로 반대되는 알파벳 사전 생성.

    static Map<Character, Character> makeDict() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Character> alphaInfo = new HashMap<>();
        for(int i=0; i<alphabet.length(); i++) {
            alphaInfo.put(alphabet.charAt(i), alphabet.charAt(25-i));
            alphaInfo.put(Character.toLowerCase(alphabet.charAt(i)), Character.toLowerCase(alphabet.charAt(25-i)));
        }
        return alphaInfo;
    }

    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> alphaInfo = makeDict();
        for(char w : word.toCharArray()) {
            Object ob = alphaInfo.get(w);
            answer += ob == null ? w : alphaInfo.get(w);
        }
        return answer;
    }
}

package onboarding;

import java.util.HashMap;
public class Problem4 {
    public static String solution(String word) {
        HashMap<String,String> map=new HashMap<>();
        String answer = "";
        alphabetMapping(map);
        /*문자열을 순차적으로 순환*/
        for (int i=0;i<word.length();i++) {
            answer = addReversedStr(word, map, answer, i);
        }
        return answer;
    }
    /**해시구조를 이용해 문자를 치환**/
    private static String addReversedStr(String word, HashMap<String, String> map, String answer, int i) {
        String s = String.valueOf(word.charAt(i));
        answer += map.getOrDefault(s, s);               /*해시맵을 가지고 문자를 치환하여 정답 문자열에 추가*/
        return answer;
    }

    /**알파벳을 각기 매핑**/
    private static void alphabetMapping(HashMap<String, String> map) {
        String forward="ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
        String backward = "ZYXWVUTSRQPONMLKJIHGFEDCBA zyxwvutsrqponmlkjihgfedcba";
        for (int i = 0; i < forward.length(); i++) {
            map.put(String.valueOf(forward.charAt(i)), String.valueOf(backward.charAt(i))); /*매핑*/
        }
    }
}

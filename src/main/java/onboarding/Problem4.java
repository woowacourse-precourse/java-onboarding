package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        return getReverseResult(word);
    }

    private static Map<String, String> initAlphaMap() {
        // 알파벳 키-값으로 매핑해서 초기화 해주는 메소드
        Map<String, String> map = new HashMap<>();

        // 대문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 65 + i;
            int right = 90 - i;
            map.put(String.valueOf((char) left), String.valueOf((char) right));
        }

        // 소문자 매핑
        for (int i = 0; i < 26; i++) {
            int left = 97 + i;
            int right = 122 - i;
            map.put(String.valueOf((char) left), String.valueOf((char) right));
        }

        return map;
    }

    private static String getReverseResult(String word){
        // 문장의 모든 알파벳을 반대로 변환해주는 메소드
        Map<String, String> map = initAlphaMap();
        List<String> newWordList = new ArrayList<>();

        for(int i=0; i<word.length(); i++){
            String now = String.valueOf(word.charAt(i));
            if (now.equals(" ")){
                newWordList.add(now);
            }
            else{
                newWordList.add(map.get(now));
            }
        }
        return String.join("", newWordList);
    }

}

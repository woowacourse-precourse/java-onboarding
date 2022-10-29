package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        initTwoWordMap(forms);
        return answer;
    }

    private static Map<String, Integer> initTwoWordMap(List<List<String>> forms) {
        // 2개로 된 모든 단어의 개수를 세어주는 메소드
        Map<String, Integer> map = new HashMap<>();
        for (List<String> form : forms) {
            String username = form.get(1);
            for (int i = 0; i < username.length() - 1; i++) {
                String twoWord = String.valueOf(username.charAt(i)) + String.valueOf(username.charAt(i+1));
                if (map.containsKey(twoWord)){
                    map.put(twoWord, map.get(twoWord) + 1);
                }
                else {
                    map.put(twoWord, 1);
                }
            }
        }
        return map;
    }
    
}

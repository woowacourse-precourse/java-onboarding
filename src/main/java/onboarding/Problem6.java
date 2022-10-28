package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    static Map<String, Integer> makeTwoLetters(List<List<String>> forms){
        Map<String, Integer> map = new HashMap<>();

        for(List list : forms){
            String str = (String)list.get(1);
            putDevidedIntoMap(str, map);
        }

        return map;
    }

    static void putDevidedIntoMap(String str, Map<String, Integer> map){
        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }
    }
}

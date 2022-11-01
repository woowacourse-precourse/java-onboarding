package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }



    public static void addHashMap(HashMap<String, List<String>> hashMap, String key, String value) {
        if(hashMap.containsKey(key))
            hashMap.get(key).add(value);
        else
            hashMap.put(key,new ArrayList<>(List.of(value)));
    }
}

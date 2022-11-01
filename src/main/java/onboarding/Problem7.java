package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> nameMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static Map<String, Integer> getId(List<List<String>> friends){
        for (List<String> friend: friends){
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            if (!nameMap.containsKey(name1))
                nameMap.put(name1, nameMap.size());
            if (!nameMap.containsKey(name2))
                nameMap.put(name2, nameMap.size());
        }
        return nameMap;
    }
}

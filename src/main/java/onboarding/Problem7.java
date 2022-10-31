package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> map;
    static Map<String, Integer> answerMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        map = new HashMap<>();
        answerMap = new HashMap<>();
        for (List<String> friend : friends) {
            String person1 = friend.get(0);
            String person2 = friend.get(1);

            List<String> newList = map.getOrDefault(person1, new ArrayList<>());
            newList.add(person2);
            map.put(person1, newList);
            newList = map.getOrDefault(person2, new ArrayList<>());
            newList.add(person1);
            map.put(person2, newList);
        }

        checkKnowingTogether(user);
        return answer;
    }
    public static void checkKnowingTogether(String user){
        List<String> userList = map.get(user);
        for (String s : userList) {
            List<String> list = map.get(s);
            for (String s1 : list) {
                if(s1.equals(user)) continue;
                answerMap.put(s1, answerMap.getOrDefault(s1, 0)+10);
            }
        }
    }
}

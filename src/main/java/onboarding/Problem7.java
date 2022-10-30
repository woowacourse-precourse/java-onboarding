package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String,Integer> friendsMap= new HashMap<>();
        return answer;
    }

    public static HashMap<String, Set<String>> createFriendsList(List<List<String>> friends){
        HashMap<String, Set<String>> map = new HashMap<>();
        for(List<String> friend : friends){
            Set<String> set = map.getOrDefault(friend.get(0),new TreeSet<>());
            set.add(friend.get(1));
            map.put(friend.get(0),set);
            set = map.getOrDefault(friend.get(1),new TreeSet<>());
            set.add(friend.get(0));
            map.put(friend.get(1),set);
        }
        return map;
    }
}

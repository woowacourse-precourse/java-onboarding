package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, List<String>> friendship = Friendship(friends);
        System.out.println("friendship.keySet() = " + friendship.keySet());
        System.out.println("friendship.values() = " + friendship.values());
        return answer;
    }

    public static HashMap<String, List<String>> Friendship(List<List<String>> friends) {
        HashMap<String, List<String>> friendship= new HashMap<>();

        for(List<String> friend : friends){
            String user1 = friend.get(0);
            String user2 = friend.get(1);

            addHashMap(friendship,user1,user2);
            addHashMap(friendship,user2,user1);
        }

        return friendship;
    }

    public static void addHashMap(HashMap<String, List<String>> hashMap, String key, String value) {
        if(hashMap.containsKey(key))
            hashMap.get(key).add(value);
        else
            hashMap.put(key,new ArrayList<>(List.of(value)));
    }
}

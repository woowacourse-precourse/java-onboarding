package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList;
        return answer;
    }
    
    private static Map<String,HashSet<String>> setFriend(List<List<String>> friends) {
        Map<String, HashSet<String>> friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(friendMap.containsKey(friend1))
                friendMap.get(friend1).add(friend2);

            if(!friendMap.containsKey(friend1))
                friendMap.put(friend1, new HashSet<>(List.of(friend2)));

            if(friendMap.containsKey(friend2))
                friendMap.get(friend2).add(friend1);

            if(!friendMap.containsKey(friend2))
                friendMap.put(friend2, new HashSet<>(List.of(friend1)));

        }
        return friendMap;
    }

    private static Map<String, Integer> getFriendScore(String user, Map<String, HashSet<String>> friendMap) {
        Map<String, Integer> friendScoreMap = new HashMap<>();
        HashSet<String> usersFriendSet = friendMap.get(user);
        HashSet<String> acquaintance = new HashSet<>();

        for (String keyUser : friendMap.keySet()) {
            if (user.equals(keyUser))
                continue;
            if(usersFriendSet.contains(keyUser))
                continue;
            acquaintance.addAll(friendMap.get(keyUser));
            acquaintance.retainAll(usersFriendSet);
            friendScoreMap.put(keyUser,acquaintance.size()*10);
        }

        return friendScoreMap;
    }
}

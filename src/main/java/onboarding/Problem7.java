package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendGraph = new HashMap<>();
        for(List<String> friend: friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            if (friendGraph.containsKey(friend1))
                friendGraph.get(friend1).add(friend2);
            else
                friendGraph.put(friend1, new ArrayList<>(List.of(friend2)));
            if (friendGraph.containsKey(friend2))
                friendGraph.get(friend2).add(friend1);
            else
                friendGraph.put(friend2, new ArrayList<>(List.of(friend1)));
        }
        Map<String, Integer> friendScore = new HashMap<>();
        List<String> usersFriendList = friendGraph.getOrDefault(user, Collections.emptyList());
        if (!usersFriendList.isEmpty()){
            for(String keyUser : friendGraph.keySet()){
                if (keyUser.equals(user))
                    continue;
                if (usersFriendList.contains(keyUser))
                    continue;
                for (String valFriend : friendGraph.get(keyUser)){
                    if (usersFriendList.contains(valFriend))
                        friendScore.put(keyUser, friendScore.containsKey(keyUser) ? friendScore.get(keyUser) + 1 : 1);
                }
            }
        }
        friendScore.replaceAll((u, v) -> friendScore.get(u) * 10);

        Map<String, Integer> visiteScore = new HashMap<>();
        for (String visitor : visitors){
            if (usersFriendList.contains(visitor))
                continue;
                visiteScore.put(visitor, visiteScore.containsKey(visitor) ? visiteScore.get(visitor) + 1 : 1);
        }

        friendScore.forEach((k, v) -> visiteScore.merge(k, v, Integer::sum));
        Map<String, Integer> totalScore = visiteScore.entrySet().stream().sorted(Collections
        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
        .thenComparing(Map.Entry.comparingByKey()))
        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));

        
        return totalScore.keySet().stream().limit(5).collect(Collectors.toCollection(ArrayList::new));
    }
}

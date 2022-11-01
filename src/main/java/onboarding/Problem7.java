package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String,HashSet<String>> friendMap = setFriend(friends);
        Map<String, Integer> friendScoreMap = getFriendScore(user,friendMap);
        Map<String, Integer> visitorScoreMap = getVisitorScore(user, friendMap, visitors);

        return getRecommendedFriend(friendScoreMap, visitorScoreMap);
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

    private static Map<String, Integer> getVisitorScore(String user, Map<String, HashSet<String>> friendMap, List<String> visitors) {
        HashSet<String> usersFriendSet = friendMap.get(user);
        Map<String, Integer> visitorScoreMap = new HashMap<>();

        for (String visitor : visitors) {
            if (usersFriendSet.contains(visitor))
                continue;
            visitorScoreMap.put(visitor,visitorScoreMap.containsKey(visitor) ? visitorScoreMap.get(visitor) + 1 : 1);
        }
        return visitorScoreMap;
    }

    private static List<String> getRecommendedFriend(Map<String, Integer> friendScoreMap, Map<String, Integer> visitorScoreMap) {
        List<String> answer = new ArrayList<>();
        friendScoreMap.forEach((k, v) -> visitorScoreMap.merge(k, v, Integer::sum));

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(visitorScoreMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            if(answer.size() < 5){
                answer.add(entry.getKey());
            }
        }

        return answer;
    }
}

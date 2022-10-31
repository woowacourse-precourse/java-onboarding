package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsMap = makeFriendsGraph(friends);
        Map<String, Integer> scoreMap = new HashMap<>();


        getScoreSameFriends(friendsMap, user, scoreMap);
        System.out.println(friendsMap);
        System.out.println(scoreMap);
        return answer;
    }

    private static void getScoreSameFriends(Map<String, List<String>> friendsMap, String target, Map<String, Integer> scoreMap){
        List<String> targetFriends = friendsMap.get(target);

        for(Map.Entry<String, List<String>> entry : friendsMap.entrySet()){
            if (entry.getKey().equals(target)){
                continue;
            }

            List<String> friendFriendShip = entry.getValue();
            ArrayList<String> intersect = new ArrayList<>(targetFriends);
            intersect.retainAll(friendFriendShip);
            scoreMap.put(entry.getKey(), 10 * intersect.size());
        }
    }

    private static Map<String, List<String>> makeFriendsGraph(List<List<String>> friends){
        Map<String, List<String>> friendsMap = new HashMap<>();

        for (List<String> relation : friends){
            List<String> relationship = friendsMap.getOrDefault(relation.get(0), new ArrayList<>());
            relationship.add(relation.get(1));
            friendsMap.put(relation.get(0),relationship);
            relationship = friendsMap.getOrDefault(relation.get(1), new ArrayList<>());
            relationship.add(relation.get(0));
            friendsMap.put(relation.get(1),relationship);
        }

        return friendsMap;
    }
}

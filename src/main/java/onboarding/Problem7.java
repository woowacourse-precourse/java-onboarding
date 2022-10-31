package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, Set<String>> friendsMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> pointMap = new HashMap<>();

        for (var friendship : friends) {
            String user1 = friendship.get(0);
            String user2 = friendship.get(1);
            setFriendsMap(user1, user2);
            setFriendsMap(user2, user1);
        }

        Set<String> userFriendsSet = friendsMap.getOrDefault(user, Collections.emptySet());
        for (var friend:friendsMap.keySet()){
            if (friend.equals(user))
                continue;
            Set<String> friendsKnowTogether= new HashSet<>(friendsMap.get(friend));
            friendsKnowTogether.retainAll(userFriendsSet);
            int numberOfFriendsKnowTogether = friendsKnowTogether.size();
            int pointsByEachFriendKnowTogether = 10;
            int pointsByFriendsKnowTogether = numberOfFriendsKnowTogether * pointsByEachFriendKnowTogether;
            pointMap.put(friend, pointMap.getOrDefault(friend, 0) +  pointsByFriendsKnowTogether );
        }

        for (var visitor:visitors) {
            int pointsByVisiting = 1;
            pointMap.put(visitor, pointMap.getOrDefault(visitor, 0) + pointsByVisiting);
        }

        List<Map.Entry<String, Integer>> pointList = new ArrayList<>(pointMap.entrySet());
        Collections.sort(pointList, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        for (var friendAndPoint:pointList) {
            String friend = friendAndPoint.getKey();
            if (answer.size() == 5)
                break;
            if (!userFriendsSet.contains(friend))
                answer.add(friend);
        }

        return answer;
    }


    public static void setFriendsMap(String user1, String user2) {
        if (!friendsMap.containsKey(user1)) {
            friendsMap.put(user1, new HashSet<>());
        }
        friendsMap.get(user1).add(user2);
    }
}

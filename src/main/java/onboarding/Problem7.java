package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendsMemory memory = new FriendsMemory(new HashMap<>(), new HashMap<>());

        friends.forEach(f -> addFriendList(f, memory));
        increaseFriendPoint(user, memory);
        increaseVisitorPoint(visitors, user, memory);

        return memory.getRecommendPoint().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void increaseVisitorPoint(List<String> visitors, String user, FriendsMemory memory) {
        Map<String, List<String>> friendsList = memory.getFriendsList();
        Map<String, Integer> recommendPoint = memory.getRecommendPoint();
        List<String> userFriends = friendsList.get(user);

        visitors.stream()
                .filter(v -> !userFriends.contains(v))
                .forEach( v -> recommendPoint.put(v, recommendPoint.getOrDefault(v, 0) + 1));
    }

    private static void increaseFriendPoint(String user, FriendsMemory memory) {
        Map<String, List<String>> friendsList = memory.getFriendsList();
        Map<String, Integer> recommendPoint = memory.getRecommendPoint();
        List<String> userFriends = friendsList.get(user);

        userFriends.stream()
                .map(friendsList::get)
                .forEach(friends -> friends.stream()
                        .filter(f -> !f.equals(user) && !userFriends.contains(f))
                        .forEach(f -> recommendPoint.put(f, recommendPoint.getOrDefault(f, 0) + 10))
                );
    }

    private static void addFriendList(List<String> friend, FriendsMemory memory) {
        Map<String, List<String>> friendsList = memory.getFriendsList();
        int flag = -1;

        for (int i = 0 ; i < 2 ; i++) {
            if (!friendsList.containsKey(friend.get(i))) {
                friendsList.put(friend.get(i), new ArrayList<>());
            }

            flag *= -1;
            friendsList.get(friend.get(i)).add(friend.get(i + flag));
        }
    }
}

class FriendsMemory {
    private final Map<String, List<String>> friendsList;
    private final Map<String, Integer> recommendPoint;

    public FriendsMemory(Map<String, List<String>> friendsMap, Map<String, Integer> pointMap) {
        this.friendsList = friendsMap;
        this.recommendPoint = pointMap;
    }

    public Map<String, List<String>> getFriendsList() {
        return friendsList;
    }

    public Map<String, Integer> getRecommendPoint() {
        return recommendPoint;
    }
}

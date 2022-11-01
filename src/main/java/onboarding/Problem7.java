package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> getUserFriendsList(String user, List<List<String>> friends) {
        List<String> userFriendsList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (Objects.equals(friend.get(0), user)) {
                userFriendsList.add(friend.get(1));
            }
            if (Objects.equals(friend.get(1), user)) {
                userFriendsList.add(friend.get(0));
            }
        }
        return userFriendsList;
    }

    private static HashMap<String, Integer> getFriendsCount(List<List<String>> friends, List<String> userFriendsList, String user, HashMap<String, Integer> map) {
        for (List<String> friend : friends) {
            if (userFriendsList.contains(friend.get(0)) && !userFriendsList.contains(friend.get(1)) && !Objects.equals(friend.get(1), user)) {
                if (map.containsKey(friend.get(1))) {
                    map.put(friend.get(1), map.get(friend.get(1)) + 10);
                } else {
                    map.put(friend.get(1), 10);
                }
            }
            if (userFriendsList.contains(friend.get(1)) && !userFriendsList.contains(friend.get(0)) && !Objects.equals(friend.get(0), user)) {
                if (map.containsKey(friend.get(0))) {
                    map.put(friend.get(0), map.get(friend.get(0)) + 10);
                } else {
                    map.put(friend.get(0), 10);
                }
            }
        }
        return map;
    }
}

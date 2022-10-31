package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friendsOfUser = new ArrayList<>();
        Map<String, Integer> scoreMap = new HashMap<>();

        findFriendsOfUser(user, friends, friendsOfUser);

        addAcquaintanceInMap(user, friends, friendsOfUser, scoreMap);

        return answer;
    }

    private static void addAcquaintanceInMap(String user, List<List<String>> friends, List<String> friendsOfUser, Map<String, Integer> scoreMap) {
        for (List<String> friend : friends) {
            for (String friendOfUser : friendsOfUser) {
                if (friend.contains(friendOfUser) && !friend.contains(user)) {
                    for (int i = 0; i < friend.size(); i++) {
                        if (!friend.get(i).equals(friendOfUser)) {
                            if (!scoreMap.containsKey(friend.get(i))) {
                                scoreMap.put(friend.get(i), 10);
                            } else {
                                int score = scoreMap.get(friend.get(i)) + 10;
                                scoreMap.put(friend.get(i), score);
                            }
                        }
                    }

                }
            }
        }
    }

    private static void findFriendsOfUser(String user, List<List<String>> friends, List<String> friendsOfUser) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (String friend : friends.get(i)) {
                    if (!friend.equals(user)) {
                        friendsOfUser.add(friend);
                    }
                }
            }
        }
    }
}

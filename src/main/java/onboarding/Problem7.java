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

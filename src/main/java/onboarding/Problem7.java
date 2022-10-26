package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> userToScore = new HashMap<>();
        List<String> myFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                myFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                myFriends.add(friend.get(0));
            }
        }

        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }
            if (myFriends.contains(friend.get(0))) {
                userToScore.put(friend.get(1), userToScore.getOrDefault(friend.get(1), 0) + 10);
            }
            if (myFriends.contains(friend.get(1))) {
                userToScore.put(friend.get(0), userToScore.getOrDefault(friend.get(0), 0) + 10);
            }
        }
        return answer;
    }
}

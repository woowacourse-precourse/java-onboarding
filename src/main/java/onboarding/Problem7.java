package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> userFriends = friendList(user, friends);
        HashMap<String, Integer> recommendScore = acquaintance(friends, userFriends);

        return answer;
    }

    private static List<String> friendList(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

    private static HashMap<String, Integer> acquaintance(List<List<String>> friends, List<String> userFriends) {
        HashMap<String, Integer> recommendScore = new HashMap<>();
        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0))) {
                String person = friend.get(1);
                recommendScore.put(person, recommendScore.getOrDefault(person, 0)+10);
            } else if (userFriends.contains(friend.get(1))) {
                String person = friend.get(0);
                recommendScore.put(person, recommendScore.getOrDefault(person, 0)+10);
            }
        }
        return recommendScore;
    }
}

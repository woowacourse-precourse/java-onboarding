package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        List<String> sameFriends = new ArrayList<>();

        Map<String, Integer> friendScore = new HashMap<>();

        for (List<String> strings : friends) {
            if (strings.get(0).equals(user)) {
                userFriends.add(strings.get(1));
            } else if (strings.get(1).equals(user)) {
                userFriends.add(strings.get(0));
            }
        }
        for (List<String> friend : friends) {
            for (String userFriend : userFriends) {
                if (friend.get(0).equals(userFriend) && !user.equals(friend.get(1))) {
                    sameFriends.add(friend.get(1));
                }
            }
        }
        for (String sameFriend : sameFriends) {
            if (!user.equals(sameFriend) && !userFriends.contains(sameFriend)) {
                friendScore.put(sameFriend, friendScore.getOrDefault(sameFriend, 0) + 10);
            }
        }
        for (String visits : visitors) {
            if (!userFriends.contains(visits)) {
                friendScore.put(visits, friendScore.getOrDefault(visits, 0) + 1);
            }
        }
        List<String> visitorScores = new ArrayList<>(friendScore.keySet());
        visitorScores.sort(((o1, o2) ->
                friendScore.get(o2).compareTo(friendScore.get(o1))));

        int count = Math.min(friendScore.size(), 5);
        for (int i = 0; i < count; i++) {
            answer.add(visitorScores.get(i));
        }
        return answer;
    }

}

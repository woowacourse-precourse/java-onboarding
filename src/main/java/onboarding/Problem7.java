package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> scoreMap = new HashMap<>();
        Set<String> oldFriends = getOldFriends(user, friends);
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                for (String oldFriend: oldFriends) {
                    if (oldFriend.equals(friends.get(i).get(j))) {
                        String opposite = friends.get(i).get(1-j);
                        scoreMap.put(opposite, scoreMap.get(opposite) + 10);
                    }
                }
            }
        }

        for (String visitor: visitors) {
            int score;
            score = scoreMap.getOrDefault(visitor, 0);
            scoreMap.put(visitor, score + 1);
        }

        return answer;
    }

    private static Set<String> getOldFriends(String user, List<List<String>> friends) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j).equals(user)) {
                    set.add(friends.get(i).get(1-j));
                    break;
                }
            }
        }
        return set;
    }
}

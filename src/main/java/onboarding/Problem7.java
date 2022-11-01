package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        int maxRcm = 5;
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();
        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        friendsList = relateFriend(friends);
        friendScore = getFriendScore(friendsList, user);
        friendScore = getVisitScore(friendScore, visitors);

        return answer;
    }

    static HashMap<String, List<String>> relateFriend(List<List<String>> friends) {

        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if (friendsList.containsKey(name1)) {
                friendsList.get(name1).add(name2);
                continue;
            }
            friendsList.put(name1, new ArrayList<>(List.of(name2)));
        }

        return friendsList;
    }

    static HashMap<String, Integer> getFriendScore(HashMap<String, List<String>> friendsList, String user) {

        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        for (String key : friendsList.keySet()) {
            if (friendsList.get(key).contains(user)) {
                for (String friend : friendsList.get(key)) {
                    if (friendScore.containsKey(friend)) {
                        friendScore.put(friend, friendScore.get(friend) + 10);
                        continue;
                    }
                    friendScore.put(friend, 10);
                }
            }
        }

        return friendScore;
    }

    static HashMap<String, Integer> getVisitScore(HashMap<String, Integer> friendScore, List<String> visitors) {
        for (String visitor : visitors) {
            if (friendScore.containsKey(visitor)) {
                friendScore.put(visitor, friendScore.get(visitor) + 1);
                continue;
            }
            friendScore.put(visitor, 1);
        }

        return friendScore;
    }
}

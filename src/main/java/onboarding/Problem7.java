package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, List<String>> friendsInfo = setFriendsInfo(friends);
        Map<String, Integer> score = new HashMap<>();

        addVisitorScore(score, visitors);

        return answer;
    }

    private static Map<String, List<String>> setFriendsInfo(List<List<String>> friends) {
        Map<String, List<String>> friendsInfo = new HashMap<>();

        for (List<String> relationship : friends) {
            String[] users = {relationship.get(0), relationship.get(1)};

            for (int i = 0; i < users.length; i++) {
                List<String> friendList = friendsInfo.getOrDefault(users[i], new ArrayList<>());
                friendList.add(users[(i + 1) % 2]);

                friendsInfo.put(users[i], friendList);
            }
        }

        return friendsInfo;
    }

    private static void addVisitorScore(Map<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
    }
}

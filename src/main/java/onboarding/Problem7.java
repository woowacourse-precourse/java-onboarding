package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static Map<String, List<String>> getFriendsList(List<List<String>> friends) {
        Map<String, List<String>> friendsList = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if (!friendsList.containsKey(friends.get(i).get(0))) {
                friendsList.put(friends.get(i).get(0), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(0)).add(friends.get(i).get(1));
            if (!friendsList.containsKey(friends.get(i).get(1))) {
                friendsList.put(friends.get(i).get(1), new ArrayList<>());
            }
            friendsList.get(friends.get(i).get(1)).add(friends.get(i).get(0));
        }
        return friendsList;
    }
    public static Map<String, Integer> scoreByAcquaintance(String user, Map<String, List<String>> friendsList) {
        Map<String, Integer> score = new HashMap<>();
        List<String> acquaintance = friendsList.get(user);
        friendsList.forEach((key, value) -> {
            if (key != user && !acquaintance.contains(key)) {
                score.put(key, 0);
            }
        });
        friendsList.forEach((key, value) -> {
            if (key != user && !acquaintance.contains(key)) {
                for (int i = 0; i < value.size(); i++) {
                    if (acquaintance.contains(value.get(i))) {
                        score.put(key, score.get(key) + 10);
                    }
                }
            }
        });
        return score;
    }
    public static Map<String, Integer> scoreByVisitor(String user, Map<String, Integer> score,
                                                      Map<String, List<String>> friends, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            if (score.containsKey(visitors.get(i))) {
                score.put(visitors.get(i), score.get(visitors.get(i)) + 1);
            }else if(!friends.get(user).contains(visitors.get(i))) {
                score.put(visitors.get(i), 1);
            }
        }
        return score;
    }
}


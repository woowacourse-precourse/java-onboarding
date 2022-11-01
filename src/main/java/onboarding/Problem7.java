package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, Integer> score = new TreeMap<>();
    public static Set<String> alreadyFriends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        scoreBasedOnFriends(user, friends);
        scoreBasedOnVisitors(user, visitors);
        List<String> answer = returnAnswer();
        return answer;
    }

    public static void scoreBasedOnFriends(String user, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String friendA = friends.get(i).get(0);
            String friendB = friends.get(i).get(1);

            //a나b가 user 라면 그냥 넘어가야 한다.
            if (friendA.equals(user) || friendB.equals(user)) {
                continue;
            }
            //a나 b가 user와 친구라면
            if (alreadyFriends.contains(friendA)) {
                score.put(friendB, score.getOrDefault(friendB, 10) + 10);
                continue;
            }
            if (alreadyFriends.contains(friendB)) {
                score.put(friendA, score.getOrDefault(friendA, 10) + 10);
            }
        }
    }

    public static void scoreBasedOnVisitors(String user, List<String> visitors) {

    }

    public static List<String> returnAnswer() {
        return Collections.emptyList();
    }
}

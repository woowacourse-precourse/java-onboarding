package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Set<String> myFriend = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) myFriend.add(friend.get(1));
            else if (friend.get(1).equals(user)) myFriend.add(friend.get(0));
        }

        Map<String, Integer> newFriend = new HashMap<>();
        for (List<String> friend : friends) {
            String u1 = friend.get(0);
            String u2 = friend.get(1);
            if (u1.equals(user) || u2.equals(user)) continue;

            if (myFriend.contains(u1) && !myFriend.contains(u2) && !newFriend.containsKey(u2)) {
                newFriend.put(u2, 10);
            } else if (myFriend.contains(u2) && !myFriend.contains(u1) && !newFriend.containsKey(u1)) {
                newFriend.put(u1, 10);
            }
        }

        for (String visitor : visitors) {
            if (!myFriend.contains(visitor)) {
                int temp = newFriend.getOrDefault(visitor, 0);
                newFriend.put(visitor, temp+1);
            }
        }

        Map<Integer, List<String>> scores = new TreeMap<>();
        for (String friend : newFriend.keySet()) {
            int score = newFriend.get(friend);
            List<String> users = scores.getOrDefault(-score, new ArrayList<>());
            users.add(friend);
            scores.put(-score,users);
        }

        for (int score : scores.keySet()) {
            if (score == 0 || answer.size() >= 5) break;

            List<String> users = scores.get(score);
            Collections.sort(users);

            for (String u : users) {
                answer.add(u);
                if (answer.size() >= 5) break;
            }
        }

        return answer;
    }
}

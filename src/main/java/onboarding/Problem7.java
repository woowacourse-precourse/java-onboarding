package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> friendship = new HashMap<>();

        if (!checkValidInput(user, friends, visitors)) {
            return Collections.emptyList();
        }

        connectFriends(friends, friendship);

        return answer;
    }

    private static void connectFriends(List<List<String>> friends, HashMap<String, ArrayList<String>> friendship) {
        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            if (!friendship.containsKey(userA)) {
                friendship.put(userA, new ArrayList<>());
            }
            if (!friendship.containsKey(userB)) {
                friendship.put(userB, new ArrayList<>());
            }

            friendship.get(userA).add(userB);
            friendship.get(userB).add(userA);
        }
    }

    private static boolean checkValidInput(String user, List<List<String>> friends, List<String> visitors) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        if (friends.size() == 0 || friends.size() > 10000) {
            return false;
        }
        if (visitors.size() > 10000) {
            return false;
        }

        return true;
    }
}

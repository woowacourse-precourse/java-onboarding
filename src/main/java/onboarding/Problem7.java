package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> users = new HashMap<>();
        List<String> friendList = findFriends(user, friends);
        String l0, l1;
        // Iterates through friend list
        for (List<String> l : friends) {
            l0 = l.get(0);
            l1 = l.get(1);
            if (!l.contains(user) && friendList.contains(l0)) {
                if (users.containsKey(l1)) {
                    users.put(l1, users.get(l1) + 10);
                } else {
                    users.put(l1, 10);
                }
            } else if (!l.contains(user) && friendList.contains(l1)) {
                if (users.containsKey(l0)) {
                    users.put(l0, users.get(l0) + 10);
                } else {
                    users.put(l0, 10);
                }
            }
        }
        // Iterates through visitor list
        for (String s : visitors) {
            if (!friendList.contains(s)) {
                if (users.containsKey(s)) {
                    users.put(s, users.get(s) + 1);
                } else {
                    users.put(s, 1);
                }
            }
        }
        return recommendation(users);
    }

    public static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();
        for (List<String> l : friends) {
            if (l.contains(user)) {
                friendList.add(l.get(0).equals(user) ? l.get(1) : l.get(0));
            }
        }
        return friendList;
    }

    public static List<String> recommendation(Map<String, Integer> users) {
        List<String> recommendation = new ArrayList<>();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(users.entrySet());
        sortedList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        for (int i = 0; (i < 5) && (i < sortedList.size()); i++) {
            recommendation.add(sortedList.get(i).getKey());
        }
        return recommendation;
    }
}

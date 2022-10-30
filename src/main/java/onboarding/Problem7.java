package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> users = new HashMap<String, List<String>>();
        Map<String, Integer> userScore = new LinkedHashMap<String, Integer>();
        for (List<String> friendRelationship : friends) {
            String friendR1 = friendRelationship.get(0);
            String friendR2 = friendRelationship.get(1);
            if (!userScore.containsKey(friendR1) && !user.equals(friendR1)) {
                userScore.put(friendR1, 0);
            }
            if (!userScore.containsKey(friendR2) && !user.equals(friendR2)) {
                userScore.put(friendR2, 0);
            }
            if (!users.containsKey(friendR1)) {
                users.put(friendR1, new ArrayList<String>());
            }
            if (!users.containsKey(friendR2)) {
                users.put(friendR2, new ArrayList<String>());
            }
            users.get(friendR1).add(friendR2);
            users.get(friendR2).add(friendR1);
        }

        List<String> userFriend = users.get(user);
        for (String friend : users.keySet()) {
            if (!friend.equals(user) && !userFriend.contains(friend)) {
                List<String> friendsList = users.get(friend);
                for (String item : friendsList) {
                    if ((users.get(user)).contains(item)) {
                        int score = userScore.get(friend);
                        userScore.put(friend, score + 10);
                    }
                }
            }
        }
        for (String visitor : visitors) {
            if (!userScore.containsKey(visitor) && !userFriend.contains(visitor)) {
                userScore.put(visitor, 1);
            } else {
                if (!userFriend.contains(visitor)) {
                    int score = userScore.get(visitor);
                    userScore.put(visitor, score + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entry = new LinkedList<>(userScore.entrySet());
        Collections.sort(entry, (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue().compareTo(a.getValue());
            }
        });
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> el : entry) {
            if (el.getValue() != 0) {
                result.add(el.getKey());
            }
        }

        return result;
    }
}

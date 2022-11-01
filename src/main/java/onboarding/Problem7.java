package onboarding;

import java.util.*;

public class Problem7 {
    private static Set<String> userFriendList = new HashSet<>();

    private static Map<String, Integer> scoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        saveUserFriend(user, friends);
        addFriendScore(user, friends);
        addVisitorScore(user, visitors);

        return recommendList();
    }

    private static void saveUserFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (user.equals(friend.get(0))) {
                userFriendList.add(friend.get(1));
            } else if (user.equals(friend.get(1))) {
                userFriendList.add(friend.get(0));
            }
        }
    }

    private static void addFriendScore(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (isUserFriend(friend.get(0))) {
                if (isNewFriend(user, friend.get(1))) {
                    addScore(friend.get(1), 10);
                }
            } else if (isUserFriend(friend.get(1))) {
                if (isNewFriend(user, friend.get(0))) {
                    addScore(friend.get(0), 10);
                }
            }
        }
    }

    private static void addVisitorScore(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (isNewFriend(user, visitor)) {
                addScore(visitor, 1);
            }
        }
    }

    private static void addScore(String friend, int score) {
        if (scoreMap.containsKey(friend)) {
            scoreMap.replace(friend, scoreMap.get(friend) + score);
        } else {
            scoreMap.put(friend, score);
        }
    }

    private static List<String> recommendList() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());

        List<String> answer = new ArrayList<>();
        entries.sort(Map.Entry.comparingByValue());

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            if (cnt == 5) break;
            answer.add(entry.getKey());
            cnt++;
        }
        return answer;
    }

    private static boolean isUserFriend(String friend) {
        return userFriendList.contains(friend);
    }

    private static boolean isNewFriend(String user, String friend) {
        return !userFriendList.contains(friend) && !user.equals(friend);
    }
}

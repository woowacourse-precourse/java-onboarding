package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {

    private static Set<String> uniqueUser = new HashSet<>();

    private static Map<String, Integer> scoreMap = new HashMap<>();

    private static List<String> userFriends = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        if (!isFriendsOutOfLength(friends) || !isVisitorsOutOfLength(visitors)) {
            return new ArrayList<>();
        }

        findUsers(friends, visitors);

        makeScoreMap();

        for (List<String> list : friends) {
            findUserFriends(list, user);
        }

        for (List<String> list : friends) {
            calculateScore(list, visitors);
        }

        removeAlreadyFriends(user);

        return recommend();
    }

    private static boolean isFriendsOutOfLength(List<List<String>> friends) {
        return friends.size() >= 1 && friends.size() <= 10000;
    }

    private static boolean isVisitorsOutOfLength(List<String> visitors) {
        return visitors.size() <= 30000;
    }

    private static void findUsers(List<List<String>> friends, List<String> visitors) {
        uniqueUser.addAll(visitors);

        for (List<String> friend : friends) {
            uniqueUser.add(friend.get(0));
            uniqueUser.add(friend.get(1));
        }
    }

    private static void makeScoreMap() {
        for (String s : uniqueUser) {
            scoreMap.put(s, 0);
        }
    }

    private static void findUserFriends(List<String> friends, String user) {
        if (friends.get(0).equals(user)) {
            userFriends.add(friends.get(1));
        }
        if (friends.get(1).equals(user)) {
            userFriends.add(friends.get(0));
        }
    }

    private static void calculateScore(List<String> friends, List<String> visitors) {
        if (userFriends.contains(friends.get(0))) {
            scoreMap.replace(friends.get(1), scoreMap.get(friends.get(0)) + 10);
        }

        if (userFriends.contains(friends.get(1))) {
            scoreMap.replace(friends.get(0), scoreMap.get(friends.get(0)) + 10);
        }

        for (String visitor : visitors) {
            scoreMap.replace(visitor, scoreMap.get(visitor) + 1);
        }
    }

    private static void removeAlreadyFriends(String user) {
        scoreMap.remove(user);
        for (String s : userFriends) {
            scoreMap.remove(s);
        }
    }

    private static List<String> recommend() {
        List<Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());

        List<String> answer = new ArrayList<>();
        entries.sort(Entry.comparingByValue());

        int cnt = 0;
        for (Entry<String, Integer> entry : entries) {
            if (cnt == 5) break;
            if (entry.getValue() != 0 && isIdLowerCase(entry.getKey()) && isIdOutOfLength(entry.getKey())) {
                answer.add(entry.getKey());
            }
            cnt++;
        }
        return answer;
    }

    private static boolean isIdOutOfLength(String id) {
        return id.length() >= 1 && id.length() <= 30;
    }

    private static boolean isIdLowerCase(String id) {
        boolean b = true;
        char[] chars = id.toCharArray();
        for (char c : chars) {
            if (!(c >= 'a' && c <= 'z')) {
                b = false;
                break;
            }
        }
        return b;
    }
}

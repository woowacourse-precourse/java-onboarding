package onboarding;

import java.util.*;

public class Problem7 {
    private static Set<String> uniqueUser = new HashSet<>();

    private static Map<String, Integer> scoreMap = new HashMap<>();

    private static List<String> userFriends = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        findUsers(friends, visitors);
        makeScoreMap();

        for (List<String> list : friends) {
            findUserFriends(list, user);
        }

        return answer;
    }

    private static void findUsers(List<List<String>> friends, List<String> visitors) {
        for (String s : visitors) {
            uniqueUser.add(s);
        }

        for (int i = 0; i < friends.size(); i++) {
            uniqueUser.add(friends.get(i).get(0));
            uniqueUser.add(friends.get(i).get(1));
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
}

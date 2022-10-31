package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static HashMap<String, Integer> recommendedFriends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendsList = friends.get(i);
            findUserFriend(friendsList, user);
        }
        System.out.println(userFriends);

        for (int i = 0; i < friends.size(); i++) {
            List<String> friendsList = friends.get(i);
            findRecommendedFriend(friendsList, user);
        }
        System.out.println(recommendedFriends);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void findRecommendedFriend(List<String> friendsList, String user) {
        for (int i = 0; i < userFriends.size(); i++) {
            if (friendsList.contains(userFriends.get(i)) && !friendsList.contains(user)) {
                addRecommendedFriend(friendsList, userFriends.get(i));
            }
        }
    }

    private static void addRecommendedFriend(List<String> friendsList, String userFriend) {
        if (friendsList.indexOf(userFriend) == 0) {
            recommendedFriends.put(friendsList.get(1), 0);
        }

        if (friendsList.indexOf(userFriend) == 1) {
            recommendedFriends.put(friendsList.get(0), 0);
        }
    }

    private static void findUserFriend(List<String> friendsList, String user) {
        if (friendsList.contains(user) && friendsList.indexOf(user) == 0) {
            userFriends.add(friendsList.get(1));
        }

        if (friendsList.contains(user) && friendsList.indexOf(user) == 1) {
            userFriends.add(friendsList.get(0));
        }
    }
}

package onboarding;

import java.util.*;

public class Problem7t {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> user_friends = new ArrayList<>();
        Set<String> friend_friends = new HashSet<>();

        for (List<String> list : friends) {
            for (String friend : friends_list(user, list)) {
                user_friends.add(friend);
            }
        }

        for (String friend : user_friends) {
            for (List<String> list : friends) {
                for (String friend_friend : friends_list(friend, list)) {
                    if (friend_friend == user) continue;
                    friend_friends.add(friend_friend);
                }
            }
        }

        for (int i = 0; i < friend_friends.size(); i++) {

        }
    }

    static List<String> friends_list(String user, List<String> friends) {
        List<String> friends_list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            if (user == friends.get(i)) {
                friends_list.add(friends.get(1-i));
            }
        }

        return friends_list;
    }
}
package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> unknown_users) {
        HashMap<String, HashSet<String>> all_friend_list = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> suggestion_list = new HashMap<String, Integer>();

        // make friend list
        friends.forEach((friend_info) -> {
            String userA = friend_info.get(0);
            String userB = friend_info.get(1);
            add_friend(all_friend_list, userA, userB);
            add_friend(all_friend_list, userB, userA);
        });

        HashSet<String> user_friend_list = all_friend_list.get(user);

        // add "friend of friend" point
        user_friend_list.forEach((friend_user) -> {
            all_friend_list.get(friend_user).forEach((suggestion_user) -> {
                add_point(user, user_friend_list, suggestion_list, suggestion_user, 10);
            });
        });

        // add unknown_user point
        unknown_users.forEach((unknown_user) -> {
            add_point(user, user_friend_list, suggestion_list, unknown_user, 1);
        });

        // sort
        List<String> answer = new ArrayList<>(suggestion_list.keySet());
        answer.sort((a, b) -> Integer.compare(suggestion_list.get(b), suggestion_list.get(a)));
        int endIndex = answer.size() > 5 ? 5 : answer.size();
        return answer.subList(0, endIndex);
    }

    private static void add_point(String user, HashSet<String> user_friend_list, HashMap<String, Integer> suggestion_list, String unknown_user, int point) {
        if (!user_friend_list.contains(unknown_user) && (unknown_user != user)) {
            if (!suggestion_list.containsKey(unknown_user)) {
                suggestion_list.put(unknown_user, point);
            } else {
                int unknown_user_point = suggestion_list.get(unknown_user);
                suggestion_list.put(unknown_user, unknown_user_point + point);
            }
        }
    }

    private static void add_friend(HashMap<String, HashSet<String>> all_friend_list, String userA, String userB) {
        if (!all_friend_list.containsKey(userA)) {
            HashSet<String> friend_list = new HashSet<String>() {{add(userB);}};
            all_friend_list.put(userA, friend_list);
            return;
        }
        all_friend_list.get(userA).add(userB);
    }
}
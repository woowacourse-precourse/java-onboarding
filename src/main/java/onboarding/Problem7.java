package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set user_friends = findUserFriends(user, friends);
        HashMap<String, Integer> not_user_friends = findNotUserFriends(user, friends, user_friends);
        for (int i = 0; i < visitors.size(); i++) {
            String friend_key = visitors.get(i);
            if (user_friends.contains(friend_key))
                continue;
            if (not_user_friends.containsKey(friend_key))
                not_user_friends.put(friend_key, not_user_friends.get(friend_key) + 1);
            else
                not_user_friends.put(friend_key, 1);
        }
        Set<String> s = new HashSet<>(not_user_friends.keySet());
        int count = 0;
        for (String str : s) {
            if (count > 4)
                break;
            System.out.print(str + " ");
            System.out.println(not_user_friends.get(str));
            answer.add(str);
            count++;
        }
        return answer;
    }

    public static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> answer = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++)
                if (friends.get(i).get(j) == user) {
                    answer.add(friends.get(i).get(1 - j));
                }
        }
        return answer;
    }

    public static HashMap<String, Integer> findNotUserFriends(String user, List<List<String>> friends, Set<String> user_friends) {
        HashMap<String, Integer> answer = new HashMap<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) != user && friends.get(i).get(1) != user) {
                String first = friends.get(i).get(0);
                String second = friends.get(i).get(1);
                if (user_friends.contains(first) && user_friends.contains(second))
                    continue;

                if (user_friends.contains(first) && !user_friends.contains(second)) {
                    if (answer.containsKey(second))
                        answer.put(second, answer.get(second) + 10);
                    else
                        answer.put(second, 10);
                }
                if (!user_friends.contains(first) && user_friends.contains(second)) {
                    if (answer.containsKey(first))
                        answer.put(first, answer.get(first) + 10);
                    else
                        answer.put(first, 10);
                }
            }
        }
        return answer;
    }
}

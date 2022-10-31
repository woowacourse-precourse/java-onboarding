package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friends_point = new HashMap<>();
        Set<String> user_friends = new HashSet<>();
        user_friends = FindFriends(user, user, friends);

        for (List<String> list : friends) {
            if (list.contains(user)) continue;
            else {
                for (String friend : list) {
                    friends_point.put(friend, 0);
                }
            }
        }

        for (String user_friend : user_friends) {
            friends_point.remove(user_friend);
            for (String friends_friend : FindFriends(user, user_friend, friends)) {
                friends_point.put(friends_friend, friends_point.get(friends_friend) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!(user_friends.contains(visitor))) {
                if (friends_point.keySet().contains(visitor)) {
                    friends_point.put(visitor, friends_point.get(visitor) + 1);
                    continue;
                }
                friends_point.put(visitor, 1);
            }
        }

        friends_point.values().remove(0);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(friends_point.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> answer = new ArrayList<>(friends_point.keySet());
        return answer;
    }

    static Set<String> FindFriends(String user, String one, List<List<String>> friends) {
        Set<String> one_friends = new HashSet<>();

        for (List<String> list : friends) {
            if (list.contains(one)) {
                for (String friend : list) {
                    one_friends.add(friend);
                }
            }
        }

        one_friends.remove(user);
        one_friends.remove(one);
        return one_friends;
    }
}

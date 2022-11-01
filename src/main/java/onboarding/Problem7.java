package onboarding;

import java.util.*;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>();
        Map<String, List<String>> relations = new HashMap<>();
        Set<String> myFriends = new HashSet<>();
        myFriends.add(user);

        initVisitors(visitors, scores);

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            isMyFriend(user, myFriends, name1, name2);

            addFriendList(relations, name1, name2);
            addFriendList(relations, name2, name1);
        }

        for (String myFriend : myFriends) {
            List<String> subFriends = relations.get(myFriend);

            for (String subFriend : subFriends) {
                if (!scores.containsKey(subFriend)) {
                    scores.put(subFriend, 0);
                }
                scores.put(subFriend, scores.get(subFriend) + 10);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scores.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : entryList) {
            if (!myFriends.contains(entry.getKey())) {
                result.add(entry.getKey());

                if (result.size() >= 5) {
                    break;
                }
            }
        }

        return result;
    }

    private static void addFriendList(Map<String, List<String>> relations, String name1, String name2) {
        if (!relations.containsKey(name1)) {
            relations.put(name1, new ArrayList<>());
        }
        List<String> friendList = relations.get(name1);
        friendList.add(name2);
        relations.put(name1, friendList);
    }

    private static void isMyFriend(String user, Set<String> myFriends, String name1, String name2) {
        isNameMatching(user, myFriends, name1, name2);
        isNameMatching(user, myFriends, name2, name1);
    }

    private static void isNameMatching(String user, Set<String> myFriends, String name1, String name2) {
        if (user.equals(name1)) {
            myFriends.add(name2);
        }
    }

    private static void initVisitors(List<String> visitors, Map<String, Integer> scores) {
        for (String visitor : visitors) {
            if (!scores.containsKey(visitor)) {
                scores.put(visitor, 0);
            }
            scores.put(visitor, scores.get(visitor) + 1);
        }
    }
}

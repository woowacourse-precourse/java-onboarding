package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendUsers = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                addFriendUsers(user, friend, friendUsers);
            }
        }

        Map<String, Integer> friendsScoreMap = new HashMap<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                continue;
            }

            for (String friendUser : friendUsers) {
                if (friend.contains(friendUser)) {
                    addTogetherKnowFriendsScore(friend, friendUser, friendsScoreMap);
                }
            }
        }

        for (String visitor : visitors) {
            friendsScoreMap.merge(visitor, 1, (oldValue, newValue) -> oldValue + 1);
        }

        List<Map.Entry<String, Integer>> totalScoreMapList = sortTotalScoreMapListByScore(friendsScoreMap);

        return generateResultList(totalScoreMapList, friendUsers);
    }

    private static void addFriendUsers(String user, List<String> friend, List<String> friendUsers) {
        for (int i = 0; i < friend.size(); i++) {
            if (!friend.get(i).equals(user)) {
                friendUsers.add(friend.get(i));
            }
        }
    }

    private static void addTogetherKnowFriendsScore(List<String> friend, String friendUser, Map<String, Integer> friendsScoreMap) {
        for (int i = 0; i < friend.size(); i++) {
            if (!friend.get(i).equals(friendUser)) {
                friendsScoreMap.merge(friend.get(i), 10, (oldValue, newValue) -> oldValue + 10);
            }
        }
    }

    private static List<Map.Entry<String, Integer>> sortTotalScoreMapListByScore(Map<String, Integer> friendsScoreMap) {
        List<Map.Entry<String, Integer>> totalScoreMapList = new LinkedList<>(friendsScoreMap.entrySet());
        totalScoreMapList.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey()
                         .compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        return totalScoreMapList;
    }


    private static List<String> generateResultList(List<Map.Entry<String, Integer>> totalScoreMapList, List<String> friendUsers) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> totalScoreMap : totalScoreMapList) {
            String name = totalScoreMap.getKey();
            if (friendUsers.contains(name)) {
                continue;
            }
            result.add(name);

            if (result.size() == 5) {
                break;
            }
        }
        return result;
    }
}
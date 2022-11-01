package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, List<String>> friendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriends(friendList, friend1, friend2);
            addFriends(friendList, friend2, friend1);
        }
        return friendList;
    }

    private static void addFriends(Map<String, List<String>> friendList, String friend1, String friend2) {
        if (!friendList.containsKey(friend1)) {
            friendList.put(friend1, new ArrayList<>());
            friendList.get(friend1).add(friend2);
            return;
        }
        friendList.get(friend1).add(friend2);
    }

    private static List<Map.Entry<String, Integer>> sorting(Map<String, Integer> scoreList) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(scoreList.entrySet());
        list.sort((o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });
        return list;
    }

    private static List<String> getList(List<Map.Entry<String, Integer>> list) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
        }

        if (list.size() > 5) {
            return result.subList(0, 5);
        }
        return result;
    }

    public static Map<String,Integer> getScoreList(Map<String, List<String>> friendList, List<String> visitors, String user) {
        Map<String, Integer> scoreList = new HashMap<>();
        if (friendList.get(user) != null) {
            List<String> userFriendList = friendList.get(user);
            for (String friend : friendList.keySet()) {
                List<String> list = friendList.get(friend);
                int score = getScore(userFriendList, list);
                scoreList.put(friend, score);
            }
        }
        for (String visitor : visitors) {
            if (!scoreList.containsKey(visitor)) {
                scoreList.put(visitor, 1);
            }else {
                Integer score = scoreList.get(visitor);
                score++;
                scoreList.replace(visitor, score);
            }
        }
        return scoreList;
    }

    private static int getScore(List<String> userFriendList, List<String> friendList) {
        int score = 0;
        for (String userFriend : userFriendList) {
            if (friendList.contains(userFriend)) {
                score += 10;
            }
        }
        return score;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friend_list = friendList(friends);
        Map<String, Integer> scoreList = getScoreList(friend_list, visitors, user);
        List<String> userFriends = friend_list.get(user);

        if (friend_list.get(user) != null) {
            scoreList.remove(user);
            for (String userFriend : userFriends) {
                scoreList.remove(userFriend);
            }
        }
        while(scoreList.values().remove(0));
        //정렬
        List<Map.Entry<String, Integer>> result = sorting(scoreList);

        return getList(result);
    }
}

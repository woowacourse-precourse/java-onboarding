package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendsList = getUserFriendsList(user, friends);
        HashMap<String, Integer> score = getScore(friends, visitors, userFriendsList, user);
        return getSortedScore(score);
    }

    private static List<String> getUserFriendsList(String user, List<List<String>> friends) {
        List<String> userFriendsList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (Objects.equals(friend.get(0), user)) {
                userFriendsList.add(friend.get(1));
            }
            if (Objects.equals(friend.get(1), user)) {
                userFriendsList.add(friend.get(0));
            }
        }
        return userFriendsList;
    }

    private static HashMap<String, Integer> getFriendsCount(List<List<String>> friends, List<String> userFriendsList, String user, HashMap<String, Integer> map) {
        for (List<String> friend : friends) {
            if (userFriendsList.contains(friend.get(0)) && !userFriendsList.contains(friend.get(1)) && !Objects.equals(friend.get(1), user)) {
                if (map.containsKey(friend.get(1))) {
                    map.put(friend.get(1), map.get(friend.get(1)) + 10);
                } else {
                    map.put(friend.get(1), 10);
                }
            }
            if (userFriendsList.contains(friend.get(1)) && !userFriendsList.contains(friend.get(0)) && !Objects.equals(friend.get(0), user)) {
                if (map.containsKey(friend.get(0))) {
                    map.put(friend.get(0), map.get(friend.get(0)) + 10);
                } else {
                    map.put(friend.get(0), 10);
                }
            }
        }
        return map;
    }

    private static HashMap<String, Integer> getVisitedCount(List<String> visitors, List<String> userFriendsList, HashMap<String, Integer> map) {
        for (String visitor : visitors) {
            if (!userFriendsList.contains(visitor)) {
                if (map.containsKey(visitor)) {
                    map.put(visitor, map.get(visitor) + 1);
                } else {
                    map.put(visitor, 1);
                }
            }
        }
        return map;
    }

    private static HashMap<String, Integer> getScore(List<List<String>> friends, List<String> visitors, List<String> userFriendsList, String user) {
        HashMap<String, Integer> score = new HashMap<>();
        getFriendsCount(friends, userFriendsList, user, score).forEach((key, value) -> score.merge(key, value, Integer::sum));
        getVisitedCount(visitors, userFriendsList, score).forEach((key, value) -> score.merge(key, value, Integer::sum));
        return score;
    }

    private static List<String> getSortedScore(HashMap<String, Integer> score) {
        List<String> sortedScoreList = new ArrayList<>();
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(score.entrySet());
        mapList.sort((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else {
                if (o1.getKey().compareTo(o2.getKey()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (Map.Entry<String, Integer> entry : mapList) {
            sortedScoreList.add(entry.getKey());
        }

        if (sortedScoreList.size() > 5) {
            sortedScoreList = sortedScoreList.subList(0, 5);
        }
        return sortedScoreList;
    }
}

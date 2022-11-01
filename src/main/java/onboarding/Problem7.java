package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int MAX_LENGTH = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendedFriendList = createRecommendedFriends(user, friends, visitors);
        Map<String, Integer> sortedFriendList = sortList(recommendedFriendList);
        return sortedFriendList.keySet()
                .stream()
                .limit(MAX_LENGTH)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer>  createRecommendedFriends(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendList = createFriendList(friends);
        Map<String, Integer> recommendedList = getScore(user, friendList, visitors);

        return recommendedList;
    }

    private static Map<String, Integer> sortList(Map<String, Integer> recommendedFriendList) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(recommendedFriendList.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        Map<String, Integer> sortedList = new LinkedHashMap<>();
        for (Iterator<Map.Entry<String, Integer>> iter = entryList.iterator(); iter.hasNext();) {
            Map.Entry<String, Integer> entry = iter.next();
            sortedList.put(entry.getKey(), entry.getValue());
        }

        return sortedList;
    }


    private static Map<String, List<String>> createFriendList(List<List<String>> friends) {
        Map<String, List<String>> friendList = new HashMap<>();

        for (List<String> friend: friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);
            addToList(friendList, userA, userB);
            addToList(friendList, userB, userA);
        }

        return friendList;
    }

    private static void addToList(Map<String, List<String>> friendList, String user, String friend) {
        List<String> list = getList(friendList, user);
        list.add(friend);
        friendList.put(user, list);
    }

    private static List<String> getList(Map<String, List<String>> friendList, String userA) {
        return friendList.getOrDefault(userA, new ArrayList<>());
    }

    private static Map<String, Integer> getScore(String user, Map<String, List<String>> friendList, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>();

        friendScore(user, friendList, score);
        visitorScore(user, visitors, friendList, score);

        return score;
    }

    private static void friendScore(String user, Map<String, List<String>> friendList, Map<String, Integer> score) {
        List<String> userFriends = friendList.get(user);
        for (String friend: userFriends) {
            List<String> list = friendList.get(friend);
            for (String name: list) {
                if (!isUser(user, name)) {
                    addFriendScore(score, name);
                }
            }
        }
    }


    private static void visitorScore(String user, List<String> visitors, Map<String, List<String>> friendList, Map<String, Integer> score) {
        List<String> userFriends = friendList.get(user);
        for (String visitor: visitors) {
            if (!isUserFriend(userFriends, visitor)) {
                addVisitorScore(score, visitor);
            }
        }
    }

    private static boolean isUser(String user, String name) {
        return name.equals(user);
    }

    private static boolean isUserFriend(List<String> userFriends, String visitor) {
        return userFriends.contains(visitor);
    }

    private static Integer addFriendScore(Map<String, Integer> score, String friend) {
        return score.put(friend, score.getOrDefault(friend, 0) + 10);
    }

    private static Integer addVisitorScore(Map<String, Integer> score, String visitor) {
        return score.put(visitor, score.getOrDefault(visitor, 0) + 1);
    }
}

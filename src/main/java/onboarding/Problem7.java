package onboarding;

import java.util.*;

public class Problem7 {
    private static final int MAX_RECOMMEND_COUNT = 5;
    private static final int FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> alreadyFriends = getAlreadyFriends(friends);
        Map<String, Integer> recommendPoint = getRecommendPointByFriends(friends, user);
        addRecommendPointByVisit(alreadyFriends, recommendPoint, visitors);

        return sortAndGetRecommendFriends(recommendPoint);
    }

    private static Set<String> getAlreadyFriends(List<List<String>> friends) {
        Set<String> alreadyFriends = new HashSet<>();

        for (List<String> friend : friends) {
            alreadyFriends.add(friend.get(0));
        }

        return alreadyFriends;
    }

    private static Map<String, Integer> getRecommendPointByFriends(List<List<String>> friends, String user) {
        Map<String, Integer> recommendPoint = new HashMap<>();

        for (List<String> friend : friends) {
            String newFriend = friend.get(1);
            if (!user.equals(newFriend)) {
                recommendPoint.put(newFriend, recommendPoint.getOrDefault(newFriend, 0) + FRIEND_POINT);
            }
        }

        return recommendPoint;
    }

    private static void addRecommendPointByVisit(Set<String> alreadyFriends, Map<String, Integer> recommendPoint, List<String> visitors) {
        for (String visitor : visitors) {
            if (isNewFriendVisiting(visitor, alreadyFriends)) {
                recommendPoint.put(visitor, recommendPoint.getOrDefault(visitor, 0) + VISITOR_POINT);
            }
        }
    }

    private static boolean isNewFriendVisiting(String visitor, Set<String> alreadyFriends) {
        return !alreadyFriends.contains(visitor);
    }


    private static List<String> sortAndGetRecommendFriends(Map<String, Integer> recommendPoint) {
        List<Map.Entry<String, Integer>> entryList = sortByRecommendPoint(recommendPoint);

        return getRecommendedUsers(entryList);
    }

    private static List<Map.Entry<String, Integer>> sortByRecommendPoint(Map<String, Integer> recommendPoint) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(recommendPoint.entrySet());

        entryList.sort((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        return entryList;
    }

    private static List<String> getRecommendedUsers(List<Map.Entry<String, Integer>> entryList) {
        List<String> recommendedUser = new ArrayList<>();
        int count = 0;

        for (Map.Entry<String, Integer> entry : entryList) {
            if (count == MAX_RECOMMEND_COUNT) {
                return recommendedUser;
            }
            recommendedUser.add(entry.getKey());
            count++;
        }

        return recommendedUser;
    }

}

package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int RECOMMEND_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, ArrayList<String>> friendMap = createFriendMap(friends);
        List<String> friendsOfUser = friendMap.getOrDefault(user, new ArrayList<>());
        List<String> exceptionUsers = createExceptionUsers(friendsOfUser, user);

        Map<String, Integer> recommendScore = new HashMap<>();
        addFriendScore(recommendScore, friendMap, friendsOfUser, exceptionUsers);
        addVisitorScore(recommendScore, visitors, exceptionUsers);

        List<String> answer = sortRecommendScore(recommendScore);
        return getTop5User(answer);
    }

    private static Map<String, ArrayList<String>> createFriendMap(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            storeUser(friendMap, user1, user2);
            storeUser(friendMap, user2, user1);
        }
        return friendMap;
    }

    private static List<String> createExceptionUsers(List<String> friendsOfUser, String user) {
        List<String> exceptionUsers = new ArrayList<>(friendsOfUser);
        exceptionUsers.add(user);
        return exceptionUsers;
    }

    private static void storeUser(Map<String, ArrayList<String>> friendMap, String user1, String user2) {
        ArrayList<String> friendList = friendMap.getOrDefault(user1, new ArrayList<>());
        friendList.add(user2);
        friendMap.put(user1, friendList);
    }

    private static void addFriendScore(Map<String, Integer> recommendScore, Map<String, ArrayList<String>> friendMap,
                                       List<String> friendsOfUser, List<String> exceptionUsers) {
        for (String friend : friendsOfUser) {
            addRecommendScore(recommendScore, friendMap.get(friend), exceptionUsers, FRIEND_SCORE);
        }
    }

    private static void addVisitorScore(Map<String, Integer> recommendScore, List<String> visitors,
                                        List<String> exceptionUsers) {
        addRecommendScore(recommendScore, visitors, exceptionUsers, VISITOR_SCORE);
    }

    private static void addRecommendScore(Map<String, Integer> recommendScore, List<String> candidateFriends,
                                          List<String> exceptionUsers, int score) {
        for (String friend : candidateFriends) {
            if (isException(exceptionUsers, friend)) {
                continue;
            }
            recommendScore.put(friend, recommendScore.getOrDefault(friend, 0) + score);
        }
    }

    private static boolean isException(List<String> exceptionUsers, String friend) {
        return exceptionUsers.contains(friend);
    }

    private static List<String> sortRecommendScore(Map<String, Integer> recommendScore) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(recommendScore.entrySet());

        entries.sort(
                (user1, user2) -> {
                    if (user1.getValue().equals(user2.getValue())) {
                        return user1.getKey().compareTo(user2.getKey());
                    }
                    return user2.getValue() - user1.getValue();
                }
        );

        return entries.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static List<String> getTop5User(List<String> recommendUser) {
        if (recommendUser.size() > RECOMMEND_COUNT) {
            return new ArrayList<>(recommendUser.subList(0, 5));
        }
        return recommendUser;
    }
}

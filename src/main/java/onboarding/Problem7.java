package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int USER_FIRST_INDEX = 0;
    private static final int USER_SECOND_INDEX = 1;
    private static final int INIT_SCORE_VALUE = 0;
    private static final int FRIEND_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int RETURN_MAX_SIZE = 5;
    private static final int MIN_USER_ID_LENGTH = 1;
    private static final int MAX_USER_ID_LENGTH = 30;
    private static final int MIN_FRIEND_RELATIONSHIP_SIZE = 1;
    private static final int MAX_FRIEND_RELATIONSHIP_SIZE = 10000;
    private static final int USER_IDS_SIZE = 2;
    private static final int MIN_VISITORS_SIZE = 0;
    private static final int MAX_VISITORS_SIZE = 10000;
    private static final String USER_ID_REGEX = "^[a-z]+$";
    private static final Map<String, Integer> friendRecommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friendRelationships, List<String> userTimelineVisitors) {
        initFriendRecommendScoreMap(friendRelationships, userTimelineVisitors);
        Set<String> userFriends = getUserFriends(user, friendRelationships);
        List<String> friendsOfUserFriends = getFriendsOfUserFriends(user, friendRelationships, userFriends);
        friendsOfUserFriendsAddScore(friendsOfUserFriends);
        userTimelineVisitorsAddScore(userTimelineVisitors);
        return getTopFiveScoreUser(friendRecommendScoreMap, userFriends);
    }

    private static Set<String> getUserIds(List<List<String>> friends) {
        Set<String> userIds = new HashSet<>();
        friends.forEach(nestedFriends -> {
            String friendName1 = nestedFriends.get(USER_FIRST_INDEX);
            String friendName2 = nestedFriends.get(USER_SECOND_INDEX);
            userIds.add(friendName1);
            userIds.add(friendName2);
        });
        return userIds;
    }

    private static void initFriendRecommendScoreMap(List<List<String>> friends, List<String> userTimelineVisitors) {
        Set<String> userIds = getUserIds(friends);
        userIds.forEach(userId -> friendRecommendScoreMap.put(userId, INIT_SCORE_VALUE));
        userTimelineVisitors.forEach(userTimelineVisitor -> friendRecommendScoreMap.put(userTimelineVisitor, INIT_SCORE_VALUE));
    }

    private static Set<String> getUserFriends(String userId, List<List<String>> friendRelationships) {
        Set<String> userFriends = new HashSet<>();
        friendRelationships.stream()
                .filter(friendRelationship -> friendRelationship.contains(userId))
                .forEach(friendRelationship -> {
                    userFriends.add(friendRelationship.get(USER_FIRST_INDEX));
                    userFriends.add(friendRelationship.get(USER_SECOND_INDEX));
                });
        userFriends.remove(userId);
        return userFriends;
    }

    private static List<String> getFriendsOfUserFriends(String userId, List<List<String>> friendRelationships, Set<String> userFriends) {
        List<String> friendsOfUserFriends = new ArrayList<>();
        for (String userFriend : userFriends) {
            friendRelationships.stream()
                    .filter(friendRelationship -> friendRelationship.contains(userFriend))
                    .collect(Collectors.toList())
                    .forEach(friendRelationship -> {
                        String userFriendId1 = friendRelationship.get(USER_FIRST_INDEX);
                        String userFriendId2 = friendRelationship.get(USER_SECOND_INDEX);
                        if (!userFriendId1.equals(userId) && !userFriendId1.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId1);
                        }
                        if (!userFriendId2.equals(userId) && !userFriendId2.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId2);
                        }
                    });
        }
        return friendsOfUserFriends;
    }

    private static void friendsOfUserFriendsAddScore(List<String> friendsOfUserFriends) {
        friendsOfUserFriends.forEach(friendOfUserFriends -> {
            friendRecommendScoreMap.put(friendOfUserFriends, friendRecommendScoreMap.get(friendOfUserFriends) + FRIEND_SCORE);
        });
    }

    private static void userTimelineVisitorsAddScore(List<String> userTimelineVisitors) {
        userTimelineVisitors.forEach(userTimelineVisitor -> {
            friendRecommendScoreMap.put(userTimelineVisitor, friendRecommendScoreMap.get(userTimelineVisitor) + VISITOR_SCORE);
        });
    }

    private static List<String> getTopFiveScoreUser(Map<String, Integer> friendRecommendScoreMap, Set<String> userFriends) {
        return friendRecommendScoreMap.entrySet().stream()
                .filter(friendRecommendScoreMapEntry ->
                        (friendRecommendScoreMapEntry.getValue() != 0) &&
                                (!userFriends.contains(friendRecommendScoreMapEntry.getKey()))
                )
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(friendRecommendScoreMapEntry -> friendRecommendScoreMapEntry.getKey())
                .limit(RETURN_MAX_SIZE)
                .collect(Collectors.toList());
    }

    private static boolean validateUserLength(String userId) {
        return (userId.length() >= MIN_USER_ID_LENGTH && userId.length() <= MAX_USER_ID_LENGTH);
    }

    private static boolean validateUserIdType(String userId) {
        return Pattern.compile(USER_ID_REGEX).matcher(userId).matches();
    }

    private static boolean validateFriendRelationshipsSize(List<List<String>> friendRelationships) {
        return (friendRelationships.size() >= MIN_FRIEND_RELATIONSHIP_SIZE && friendRelationships.size() <= MAX_FRIEND_RELATIONSHIP_SIZE);
    }

    private static boolean validateUserIds(List<List<String>> friendRelationships) {
        List<List<String>> filteredFriendRelationships = friendRelationships.stream()
                .filter(friendRelationship -> friendRelationship.size() == USER_IDS_SIZE)
                .collect(Collectors.toList());
        return (filteredFriendRelationships.size() == friendRelationships.size());
    }

    private static boolean validateVisitorsSize(List<String> visitors) {
        return (visitors.size() >= MIN_VISITORS_SIZE && visitors.size() <= MAX_VISITORS_SIZE);
    }
}

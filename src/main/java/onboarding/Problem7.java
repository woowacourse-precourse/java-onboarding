package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    private final static int BASE_SCORE = 0;
    private final static int SCORE_INCREMENT_PER_COMMON_FRIEND = 10;
    private final static int SCORE_INCREMENT_PER_VISIT = 1;
    private final static int NUM_MAX_RECOMMENDATIONS = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        assert (user != null);
        assert (friends != null && isContainingNoNullReference(friends));
        assert (visitors != null && isContainingNoNullReference(visitors));

        HashMap<String, HashSet<String>> userFriendsMapping = new HashMap<>();
        HashMap<String, Integer> userScoreMapping = new HashMap<>();

        mapUserFriendRelations(friends, userFriendsMapping);
        updateScoreByNumberOfCommonFriends(userScoreMapping, user, userFriendsMapping);
        updateScoreByNumberOfVisits(userScoreMapping, user, visitors, userFriendsMapping);

        return getSortedFriendRecommendationList(userScoreMapping);
    }

    private static void mapUserFriendRelations(List<List<String>> friendRelations, HashMap<String, HashSet<String>> friendsByUser) {
        for (List<String> friendRelation : friendRelations) {
            String user0 = friendRelation.get(0);
            String user1 = friendRelation.get(1);

            if (!friendsByUser.containsKey(user0)) {
                friendsByUser.put(user0, new HashSet<>());
            }
            friendsByUser.get(user0).add(user1);

            if (!friendsByUser.containsKey(user1)) {
                friendsByUser.put(user1, new HashSet<>());
            }
            friendsByUser.get(user1).add(user0);
        }
    }

    private static void updateScoreByNumberOfCommonFriends(HashMap<String, Integer> userScoreMapping, String user, HashMap<String, HashSet<String>> userFriendsMapping) {
        HashSet<String> thisUserFriends = userFriendsMapping.get(user);

        for (String otherUser : userFriendsMapping.keySet()) {
            if (otherUser.equals(user) || thisUserFriends.contains(otherUser)) {
                continue;
            }
            userScoreMapping.put(otherUser, BASE_SCORE);
        }

        for (String otherUser : userScoreMapping.keySet()) {
            HashSet<String> otherUserFriends = userFriendsMapping.get(otherUser);
            for (String thisUserFriend : thisUserFriends) {
                if (otherUserFriends.contains(thisUserFriend)) {
                    userScoreMapping.put(otherUser, userScoreMapping.get(otherUser) + SCORE_INCREMENT_PER_COMMON_FRIEND);
                }
            }
        }
    }

    private static void updateScoreByNumberOfVisits(HashMap<String, Integer> userScoreMapping, String user, List<String> visitors, HashMap<String, HashSet<String>> userFriendsMapping) {
        HashSet<String> thisUserFriends = userFriendsMapping.get(user);

        for (String visitor : visitors) {
            if (thisUserFriends.contains(visitor)) {
                continue;
            }

            if (!userScoreMapping.containsKey(visitor)) {
                userScoreMapping.put(visitor, BASE_SCORE);
            }

            userScoreMapping.put(visitor, userScoreMapping.get(visitor) + SCORE_INCREMENT_PER_VISIT);
        }
    }

    private static List<String> getSortedFriendRecommendationList(HashMap<String, Integer> userScoreMapping) {
        ArrayList<String> recommendations = new ArrayList<>();

        for (String user : userScoreMapping.keySet()) {
            if (userScoreMapping.get(user) != BASE_SCORE) {
                recommendations.add(user);
            }
        }

        recommendations.sort((o1, o2) -> {
            int comparisonResult = userScoreMapping.get(o1) - userScoreMapping.get(o2);
            if (comparisonResult == 0) {
                return o1.compareTo(o2);
            }
            return (comparisonResult * -1);
        });

        if (recommendations.size() > NUM_MAX_RECOMMENDATIONS) {
            int size = recommendations.size();
            int index = size - 1;
            while (index >= NUM_MAX_RECOMMENDATIONS) {
                recommendations.remove(index);
                index--;
            }
        }

        return recommendations;
    }

    private static boolean isContainingNoNullReference(List<?> list) {
        for (Object listedObject : list) {
            if (listedObject == null) {
                return false;
            }
            if (listedObject instanceof List) {
                return isContainingNoNullReference((List<?>) listedObject);
            }
        }
        return true;
    }
}

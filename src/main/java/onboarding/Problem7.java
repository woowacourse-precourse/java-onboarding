package onboarding;

import onboarding.problem7.Problem7Validation;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int FRIEND_TOGETHER_SCORE = 10;
    private static final int VISITOR_SCORE = 1;
    private static final int RESULT_COUNT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        if (Problem7Validation.problem7Validation(user, friends, visitors)) {
            answer = getFiveRecommendIdList(user, friends, visitors);
        }
        return answer;
    }

    private static List<String> getFiveRecommendIdList(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userSet = makeUserSet(user, friends, visitors);
        Map<String, List<String>> friendRelationMap = makeFriendsRelations(friends);
        Map<String, Integer> scoreMap = initCountScoreMap(userSet, friendRelationMap, user, visitors);
        List<String> sortingByScoreMap = new ArrayList<>(scoreMap.keySet());
        sorting(sortingByScoreMap, scoreMap);
        return getFiveList(sortingByScoreMap, scoreMap);
    }

    private static Set<String> makeUserSet(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUserSet = new HashSet<>();
        addUserSetByUser(allUserSet, user);
        addUserSetByFriends(allUserSet, friends);
        addUserSetByVisitors(allUserSet, visitors);
        return allUserSet;
    }

    private static void addUserSetByUser(Set<String> allUserSet, String user) {
        allUserSet.add(user);
    }

    private static void addUserSetByFriends(Set<String> allUserSet, List<List<String>> friends) {
        for (List<String> friendList : friends) {
            addUserSetByUserList(allUserSet, friendList);
        }
    }

    private static void addUserSetByUserList(Set<String> allUserSet, List<String> friendList) {
        for (String friend : friendList) {
            addUserSetByUser(allUserSet, friend);
        }
    }

    private static void addUserSetByVisitors(Set<String> allUserSet, List<String> visitors) {
        addUserSetByUserList(allUserSet, visitors);
    }

    private static Map<String, List<String>> makeFriendsRelations(List<List<String>> friends) {

        Map<String, List<String>> friendRelationships = new HashMap<>();

        for (List<String> friend : friends) {
            addRelationship(friendRelationships, friend.get(0), friend.get(1));
        }

        return friendRelationships;
    }

    private static void addRelationship(Map<String, List<String>> friendRelationships, String user1, String user2) {
        addKeyUser1ValueUser2(friendRelationships, user1, user2);
        addKeyUser1ValueUser2(friendRelationships, user2, user1);
    }

    private static void addKeyUser1ValueUser2(Map<String, List<String>> friendRelationships, String user1, String user2) {
        if (!friendRelationships.containsKey(user1)) {
            List<String> friends = new LinkedList<>();
            friendRelationships.put(user1, friends);
        }
        friendRelationships.get(user1).add(user2);

    }

    private static Map<String, Integer> initCountScoreMap(Set<String> userSet, Map<String, List<String>> friendRelationMap, String user, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        List<String> notUserFriendAndNotUserList = userSet.stream()
                .filter(userId -> !isUserFriendOrUser(userId, friendRelationMap, user))
                .collect(Collectors.toList());

        for (String userId :
                notUserFriendAndNotUserList) {
            int score = 0;
            score += userFriendWithThisUserFriendCount(user, userId, friendRelationMap) * FRIEND_TOGETHER_SCORE;
            if (visitors.size() > 0) {
                score += userVisitorCount(visitors, userId) * VISITOR_SCORE;
            }
            if (score > 0) {
                scoreMap.put(userId, score);
            }
        }
        return scoreMap;
    }

    private static boolean isUserFriendOrUser(String userId, Map<String, List<String>> friendRelationMap, String user) {
        boolean isTrue = true;
        if (friendRelationMap.containsKey(user)) {
            isTrue = (userId == user) || (friendRelationMap.get(user).contains(userId));
        } else if (!friendRelationMap.containsKey(user)) {
            isTrue = (userId == user);
        }
        return isTrue;
    }

    private static int userFriendWithThisUserFriendCount(String user, String thisUser, Map<String, List<String>> friendRelationMap) {
        int result = 0;
        if (friendRelationMap.containsKey(thisUser)) {
            result = (int) friendRelationMap.get(thisUser).stream()
                    .filter(friend -> isFriendWithUser(friendRelationMap,user,friend))
                    .count();
        }
        return result;
    }

    private static boolean isFriendWithUser(Map<String, List<String>> friendRelationMap, String user, String friend) {
        if (friendRelationMap.containsKey(user)) {
            return friendRelationMap.get(user).contains(friend);
        }
        return false;
    }

    private static int userVisitorCount(List<String> visitors, String thisUser) {
        return (int) visitors.stream()
                .filter(visitor -> visitor == thisUser)
                .count();
    }

    private static void sorting(List<String> sortingByScoreMap, Map<String, Integer> scoreMap) {
        sortingByScoreMap.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                Integer user1 = scoreMap.get(o1);
                Integer user2 = scoreMap.get(o2);
                if (user1 < user2) {
                    result = 1;
                } else if (user1 > user2) {
                    result = -1;
                } else if (user1 == user2) {
                    result = o1.compareTo(o2);
                }
                return result;
            }
        });
    }

    private static List<String> getFiveList(List<String> sortingByScoreMap, Map<String, Integer> scoreMap) {
        List<String> returnList = new ArrayList<>();

        for (int i = 0; i < sortingByScoreMap.size() && i < RESULT_COUNT; i++) {

            returnList.add(sortingByScoreMap.get(i));

        }
        return returnList;
    }




}

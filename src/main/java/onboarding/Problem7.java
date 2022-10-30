package onboarding;

import onboarding.problem7.Problem7Validation;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
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
        Map<String, Integer> scoreMap = initCountScoreList(userSet, friendRelationMap, user);

        return null;
    }

    private static Map<String, Integer> initCountScoreList(Set<String> userSet, Map<String, List<String>> friendRelationMap, String user) {
        Map<String, Integer> scoreMap = new HashMap<>();
        List<String> collectUserList = userSet.stream()
                .filter(userId -> !isUserFriendOrUser(userId, friendRelationMap, user))
                .collect(Collectors.toList());

        for (String userId : collectUserList) {
            scoreMap.put(userId, 0);
        }
        return scoreMap;
    }

    private static boolean isUserFriendOrUser(String userId, Map<String, List<String>> friendRelationMap, String user) {
        return ((userId == user) || (friendRelationMap.get(user).contains(userId)));
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


}

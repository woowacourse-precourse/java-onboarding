package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, List<String>> getFriendMap(List<List<String>> friends) {
        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friendPair : friends) {
            List<String> friend1 = friendMap.getOrDefault(friendPair.get(0), new ArrayList<>());
            List<String> friend2 = friendMap.getOrDefault(friendPair.get(1), new ArrayList<>());
            friend1.add(friendPair.get(1));
            friend2.add(friendPair.get(0));
            friendMap.put(friendPair.get(0), friend1);
            friendMap.put(friendPair.get(1), friend2);
        }
        return friendMap;
    }

    public static Map<String, Integer> getKnowTogetherMembersPoint(List<String> knowTogetherMembers, List<String> userAndUserFriends) {
        Map<String, Integer> points = new HashMap<>();
        for (String knowTogetherMember : knowTogetherMembers) {
            points.put(knowTogetherMember, points.getOrDefault(knowTogetherMember, 0) + getKnowTogetherMemberPoint(knowTogetherMember, userAndUserFriends));
        }
        return points;
    }

    private static int getKnowTogetherMemberPoint(String knowTogetherMember, List<String> userAndUserFriends) {
        if (userAndUserFriends.contains(knowTogetherMember)) {
            return 0;
        }
        return 10;
    }

    public static List<String> getUserFriends(Map<String, List<String>> friendMap, String user) {
        return friendMap.get(user);
    }

    public static List<String> getUserAndUserFriends(List<String> userFriends, String user) {
        userFriends.add(user);
        return userFriends;
    }

    public static List<String> getKnowTogetherMembers(Map<String, List<String>> friendMap, List<String> userFriends, String user) {
        return userFriends.stream()
                .flatMap(userFriend -> friendMap.get(userFriend).stream())
                .filter(userFriend -> isUserOrUserFriend(userFriends, user, userFriend))
                .collect(Collectors.toList());
    }

    private static boolean isUserOrUserFriend(List<String> userFriends, String user, String userFriend) {
        if (userFriend.equals(user) || userFriends.contains(userFriend)) {
            return false;
        }
        return true;
    }
}

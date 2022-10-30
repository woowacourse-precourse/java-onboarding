package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem7 {
    private static final HashMap<String, Integer> friendsScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends;

        userFriends = getUserFriends(user, friends);
        System.out.println(userFriends);

        scoringFriend(user, userFriends, friends);
        System.out.println(friendsScore);

        return answer;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            String addId = getUserToAdd(user, friend);

            if (!addId.isEmpty()) {
                userFriends.add(addId);
            }
        }

        return userFriends;
    }

    private static String getUserToAdd(String user, List<String> friend) {
        int friendIndex = friend.indexOf(user);

        if (friendIndex == 0) {
            return friend.get(1);
        } else if (friendIndex == 1) {
            return friend.get(0);
        }

        return "";
    }

    private static void scoringFriend(String user, List<String> userFriends, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (isNotFriend(user, friend)) {
                String friendId = getFriendName(userFriends, friend);
                String addId = getUserToAdd(friendId, friend);

                if (!addId.isEmpty() && isNotFriend(addId, userFriends)) {
                    System.out.println("friend of friend : " + addId);
                }
            }

        }
    }

    private static boolean isNotFriend(String user, List<String> friend) {
        return !friend.contains(user);
    }

    private static boolean isContainFriendsScore(String checkNickname) {
        return friendsScore.containsKey(checkNickname);
    }

    private static String getFriendName(List<String> userFriends, List<String> friend) {
        List<String> result = friend.stream()
                                        .filter(old -> userFriends.stream()
                                        .anyMatch(Predicate.isEqual(old)))
                                        .collect(Collectors.toList());
        return result.get(0);
    }

}

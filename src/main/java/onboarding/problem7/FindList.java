package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class FindList {
    public static List<String> findAlreadyFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> ignored : friends) {
            friendList.addAll(extractFriendList(user, friends));
        }

        friendList = friendList.stream().distinct().collect(Collectors.toList());

        return friendList;
    }

    private static List<String> extractFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendList.add(friend.stream()
                        .filter(id -> !id.equals(user))
                        .collect(Collectors.joining()));
            }
        }

        return new ArrayList<>(friendList);
    }

    public static List<String> findFriendOfFriendList(String user, List<String> userFriend, List<List<String>> friends) {
        List<String> friendOfFriendList = new ArrayList<>();

        for (String userFriendId : userFriend) {
            friendOfFriendList.addAll(extractFriendList(user, userFriendId, friends));
        }

        friendOfFriendList = friendOfFriendList.stream().distinct().collect(Collectors.toList());

        return friendOfFriendList;
    }

    private static List<String> extractFriendList(String user, String userFriendId, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(userFriendId) && !friend.contains(user)) {
                friendList.add(friend.stream()
                        .filter(id -> !id.equals(userFriendId))
                        .collect(Collectors.joining()));
            }
        }

        return new ArrayList<>(friendList);
    }

    public static List<String> findOthersList(List<String> visitor, List<String> friend, List<String> friendOfFriend) {
        return new ArrayList<>(visitor)
                .stream()
                .filter(visitorId -> (!friend.contains(visitorId) && !friendOfFriend.contains(visitorId)))
                .collect(Collectors.toList());
    }
}

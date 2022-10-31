package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class FindList {
    public static List<String> findAlreadyFriendList(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> ignored : friends) {
            friendList.addAll(extractFriendListByUser(user, friends));
        }
        friendList = friendList.stream()
                .distinct()
                .collect(Collectors.toList());

        return friendList;
    }

    private static List<String> extractFriendListByUser(String user, List<List<String>> friends) {
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

        for (List<String> friend : friends) {
            String friendOfFriend = extractFriendOfFriend(user, userFriend, friend);
            friendOfFriendList.add(friendOfFriend);
        }

        friendOfFriendList = friendOfFriendList.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());

        return friendOfFriendList;
    }

    private static String extractFriendOfFriend(String user, List<String> userFriend, List<String> elementOfFriends) {
        String friendOfFriend = null;

        for (String ignored : userFriend) {
            friendOfFriend = elementOfFriends.stream()
                    .filter(f -> ((!f.equals(user)) &&
                            (!userFriend.contains(f) || !elementOfFriends.contains(f))))
                    .collect(Collectors.joining());
        }

        if (!elementOfFriends.contains(friendOfFriend)) {
            friendOfFriend = null;
        }

        return friendOfFriend;
    }

    public static List<String> findOthersList(List<String> visitor, List<String> friend, List<String> friendOfFriend) {
        return new ArrayList<>(visitor)
                .stream()
                .filter(visitorId -> (!friend.contains(visitorId) && !friendOfFriend.contains(visitorId)))
                .collect(Collectors.toList());
    }
}

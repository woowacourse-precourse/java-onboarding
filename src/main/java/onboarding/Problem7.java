package onboarding;

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        solution(user, friends, visitors);
    }

    private static final List<String> myFriends = new ArrayList<>();
    private static final List<String> aFriendWeKnow = new ArrayList<>();
    private static final Map<String, Integer> result = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        init(friends);
        System.out.println(friendsListVerifier(user, friends));
        return null;
    }

    private static void init(List<List<String>> friends) {
        ArrayList<String> userIds = new ArrayList<>();
        for (List<String> users : friends) {
            users.forEach(user -> {
                boolean result = userIds.stream()
                        .anyMatch(id -> Objects.equals(id, user));
                if (!result) {
                    userIds.add(user);
                }
            });
        }

        for (String userId : userIds) {
            result.put(userId, 0);
        }
    }

    private static List<String> friendsListVerifier(String myId, List<List<String>> friends) {
        saveMyFriends(myId, friends);
        for (List<String> users : friends) {
            checkFriendsOfOtherUser(users);
        }
        sortList();
        removeMyId(myId);
        System.out.println("aFriendWeKnow = " + aFriendWeKnow);
        return myFriends;
    }

    private static void saveMyFriends(String myId, List<List<String>> friends) {
        for (List<String> users : friends) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).equals(myId)) {
                    if (i == 0) {
                        myFriends.add(users.get(1));
                    } else {
                        myFriends.add(users.get(0));
                    }
                }
            }
        }
    }

    private static void checkFriendsOfOtherUser(List<String> users) {
        for (int i = 0; i < users.size(); i++) {
            String userId = users.get(i);
            for (String myFriendsId : myFriends) {
                if (Objects.equals(userId, myFriendsId)) {
                    if (i == 0) {
                        if (!isMyFriend(users.get(1))) {
                            aFriendWeKnow.add(users.get(1));
                        }
                    } else {
                        if (!isMyFriend(users.get(0))) {
                            aFriendWeKnow.add(users.get(0));
                        }
                    }
                }
            }
        }
    }

    private static boolean isMyFriend(String userId) {
        for (String id : myFriends) {
            if (Objects.equals(id, userId)) {
                return true;
            }
        }
        return false;
    }

    private static void removeMyId(String myId) {
        for (int i = 0; i < aFriendWeKnow.size(); i++) {
            if (Objects.equals(aFriendWeKnow.get(i), myId)) {
                aFriendWeKnow.remove(i);
                i--;
            }
        }
    }

    private static void sortList() {
        Collections.sort(aFriendWeKnow);
    }
}

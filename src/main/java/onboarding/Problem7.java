package onboarding;

import java.util.*;

public class Problem7 {

    private static Map<String, List<String>> relations = new HashMap<>();
    private static Map<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        getFriends(friends);
        getFriendsScore(user, friends);
        return null;
    }

    private static void getFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String preFriend = friend.get(0);
            String nextFriend = friend.get(1);

            if (!relations.containsKey(preFriend)) {
                setNewList(preFriend);
            }
            if (!relations.containsKey(nextFriend)) {
                setNewList(nextFriend);
            }
            setRelations(preFriend, nextFriend);
        }
    }

    private static void setNewList(String friend) {
        List<String> friendList = new ArrayList<>();
        score.put(friend, 0);
        relations.put(friend, friendList);
    }

    private static void setRelations(String preFriend, String nextFriend) {
        List<String> preFriendList = relations.get(preFriend);
        preFriendList.add(nextFriend);

        List<String> nextFriendList = relations.get(nextFriend);
        nextFriendList.add(preFriend);
    };

    private static List<String> getFriendsScore(String user, List<List<String>> friends) {
        List<String> friendList = relations.get(user);
        for (String list : friendList) {
            List<String> knownFriends = relations.get(list);
            for (String friend : knownFriends) {
                if (friends.contains(friend)) continue;
                if (friend.equals(user)) continue;
                Integer friendScore = score.get(friend);
                score.put(friend, friendScore + 10);
            }
        }
        return friendList;
    }

}

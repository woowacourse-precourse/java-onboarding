package onboarding.problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FriendSystem {
    private static final int MAX_FAIR_INDEX = 1;
    private String user;
    private final HashSet<String> friends;
    private final Map<String, Integer> friendMap;

    public FriendSystem(String user) {
        this.friendMap = new HashMap<>();
        this.friends = new HashSet<>();
        this.user = user;
    }

    private void findFriend(List<List<String>> friendList) {
        for (List<String> friendPair : friendList) {
            checkIsUserFriend(friendPair);
        }
    }

    private void checkIsUserFriend(List<String> friendPair) {
        if (friendPair.contains(user)) {
            int userIdx = friendPair.indexOf(user);
            friends.add(friendPair.get(MAX_FAIR_INDEX-userIdx));
        }
    }

    public void findOtherFriend(List<List<String>> friendList){
        for (List<String> friendPair : friendList) {
            checkFriendPair(friendPair);
        }
    }

    private void checkFriendPair(List<String> friendPair) {
        for (int idx = 0; idx <= MAX_FAIR_INDEX; idx++) {
            String friend = friendPair.get(idx);
            checkIsFriendOfFriend(friend, idx, friendPair);
        }
    }

    private void checkIsFriendOfFriend(String friend, int idx, List<String> friendPair) {
        if (friends.contains(friend)) {
            int otherFriendIdx = MAX_FAIR_INDEX-idx;
            String otherFriend = friendPair.get(otherFriendIdx);
            checkIsOtherFriend(otherFriend);
        }
    }

    private void checkIsOtherFriend(String otherFriend) {
        if (!Objects.equals(otherFriend, user)) {
            if (!friendMap.containsKey(otherFriend)) {
                friendMap.put(otherFriend, 0);
            }
            friendMap.put(otherFriend, friendMap.get(otherFriend)+10);
        }
    }

    private void checkVisitors(List<String> visitors){
        for (String visitor : visitors) {
            addVisitorFriend(visitor);
        }
    }

    private void addVisitorFriend(String visitor) {
        if (!friends.contains(visitor)) {
            if (!friendMap.containsKey(visitor)) {
                friendMap.put(visitor, 0);
            }
            friendMap.put(visitor, friendMap.get(visitor)+1);
        }
    }
}

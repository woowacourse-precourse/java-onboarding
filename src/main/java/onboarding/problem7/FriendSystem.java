package onboarding.problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FriendSystem {
    private static final int MAX_FAIR_INDEX = 1;
    private static final int ZERO_POINT = 0;
    private static final int FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;
    private String user;
    private final HashSet<String> friends;
    private final Map<String, Integer> friendMap;

    public FriendSystem() {
        this.friendMap = new HashMap<>();
        this.friends = new HashSet<>();
        this.user = "";
    }

    public List<String> getRecommendedFriendsList(String user, List<List<String>> friends, List<String> visitors){
        initSystem(user);
        findFriend(friends);
        findOtherFriend(friends);
        checkVisitors(visitors);
        return RecommendedFriendsListSystem.getRecommendedFriendsList(friendMap);
    }

    private void initSystem(String user) {
        friends.clear();
        friendMap.clear();
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
            friendMap.put(otherFriend, getFriendPoint(otherFriend)+FRIEND_POINT);
        }
    }

    private void checkVisitors(List<String> visitors){
        for (String visitor : visitors) {
            addVisitorFriend(visitor);
        }
    }

    private void addVisitorFriend(String visitor) {
        if (!friends.contains(visitor)) {
            friendMap.put(visitor, getFriendPoint(visitor)+VISITOR_POINT);
        }
    }

    private int getFriendPoint(String recommendedFriend) {
        if (!friendMap.containsKey(recommendedFriend)) {
            return ZERO_POINT;
        }
        return friendMap.get(recommendedFriend);
    }
}

package onboarding.problem7;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class FriendSystem {
    private static final int MAX_FAIR_INDEX = 1;
    private final HashSet<String> friends;

    public FriendSystem() {
        friends = new HashSet<>();
    }

    private void findFriend(String user, List<List<String>> friendList) {
        for (List<String> friendPair : friendList) {
            checkIsUserFriend(user,friendPair);
        }
    }

    private void checkIsUserFriend(String user, List<String> friendPair) {
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
        }
    }
}

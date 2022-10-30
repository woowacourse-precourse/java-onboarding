package onboarding.problem7;


import java.util.HashSet;
import java.util.List;

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
}

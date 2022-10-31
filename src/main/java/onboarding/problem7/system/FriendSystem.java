package onboarding.problem7.system;

import java.util.List;
import java.util.Set;

public interface FriendSystem {
    void connectFriend(String userA, String userB);

    Set<String> getFriendsOf(String user);

    List<String> getRecommendFriendsOf(String user, List<String> visitors);
}

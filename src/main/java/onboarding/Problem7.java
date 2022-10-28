package onboarding;

import onboarding.problem7.system.FriendSystem;
import onboarding.problem7.system.Level2FriendSystem;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendSystem friendSystem = new Level2FriendSystem();

        for (List<String> connection : friends) {
            friendSystem.connectFriend(connection.get(0), connection.get(1));
        }

        return friendSystem.getRecommendFriendsOf(user, visitors);
    }
}

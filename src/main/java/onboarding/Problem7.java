package onboarding;

import onboarding.problem7.Friend;
import onboarding.problem7.Friends;
import onboarding.problem7.User;
import onboarding.problem7.Visitor;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        final User createUser = User.create(user);
        friends.forEach(friend -> {
            final Friend newFriend = Friend.create(friend);
            createUser.addFriend(newFriend);
        });
        visitors.forEach(visitor -> {
            final Visitor newVisitor = Visitor.create(visitor);
            createUser.addVisitor(newVisitor);
        });

        return createUser.getRecommendFriendList();
    }
}

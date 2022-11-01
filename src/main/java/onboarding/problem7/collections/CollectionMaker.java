package onboarding.problem7.collections;

import onboarding.problem7.wrapper.Friend;
import onboarding.problem7.wrapper.User;

public class CollectionMaker {
    public User makeUser(String userId) {
        return new User(userId);
    }

    public Friend makeFriendWithAAndB(User userA, User userB) {
        return new Friend(userA, userB);
    }
}

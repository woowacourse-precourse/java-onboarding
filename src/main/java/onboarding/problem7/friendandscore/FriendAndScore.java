package onboarding.problem7.friendandscore;

import onboarding.problem7.collections.FriendList;
import onboarding.problem7.collections.VisitorList;
import onboarding.problem7.wrapper.User;

import java.util.List;

public class FriendAndScore {

    private final FriendList friendList;
    private final VisitorList visitorList;
    private final int FRIENDS_OF_FRIEND_POINT;
    private final int VISITORS_POINT;

    public FriendAndScore(FriendList friendList, VisitorList visitors) {
        this.friendList = friendList;
        this.visitorList = visitors;
        this.FRIENDS_OF_FRIEND_POINT = 10;
        this.VISITORS_POINT = 1;
    }

    public List<User> getFriendsOfUserFriend(User user) {
        List<User> friendsOfUser = friendList.getFriendListOf(user);
        return friendList.getFriendsOfFriendBy(user, friendsOfUser);
    }
}

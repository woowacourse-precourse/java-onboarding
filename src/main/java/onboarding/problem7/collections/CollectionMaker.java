package onboarding.problem7.collections;

import onboarding.problem7.wrapper.Friend;
import onboarding.problem7.wrapper.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionMaker {

    private final FriendList friendList;
    private final VisitorList visitorList;

    public CollectionMaker(List<List<String>> friendList, List<String> visitors) {
        this.friendList = makeFriendList(friendList);
        this.visitorList = makeVisitorList(visitors);
    }

    public User makeUser(String userId) {
        return new User(userId);
    }

    public Friend makeFriendWithAAndB(User userA, User userB) {
        return new Friend(userA, userB);
    }

    public FriendList makeFriendList(List<List<String>> friends) {
        List<Friend> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            User userA = makeUser(friend.get(0));
            User userB = makeUser(friend.get(1));
            Friend relationshipOfAAndB = makeFriendWithAAndB(userA, userB);
            friendList.add(relationshipOfAAndB);
        }
        return new FriendList(friendList);
    }

    public VisitorList makeVisitorList(List<String> visitors) {
        List<User> visitorList = visitors.stream()
                .map(this::makeUser)
                .collect(Collectors.toList());
        return new VisitorList(visitorList);
    }
}

package onboarding.problem7;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Friends {

    private static final Integer FRIENDS_SIZE = 10000;
    private static final Integer FRIEND_SCORE = 10;

    private List<Friend> friends;

    protected Friends() {

    }

    public Friends(List<Friend> friends) {
        this.friends = friends;
    }

    public void add(Friend friend) {
        validateFriendsSize();
        if (friends.contains(friend)) {
            throw new IllegalArgumentException("이미 동일한 친구 관계가 존재합니다.");
        }
        friends.add(friend);
    }

    public List<String> getFriendList() {
        return friends.stream()
                .map(Friend::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateFriendsSize() {
        if (friends.size() > FRIENDS_SIZE) {
            throw new IllegalStateException("Friends의 크기는 10000이하어야 합니다.");
        }
    }

    public List<Recommend> getFriendsRecommend(User user, List<String> myFriendList) {
        return friends.stream()
                .filter(isNotMyFriendFilter(myFriendList))
                .filter(friendsFriendIsNotMeFilter(user))
                .map(friend -> Recommend.create(friend.getFriendName(), FRIEND_SCORE))
                .collect(Collectors.toUnmodifiableList());
    }

    private Predicate<Friend> friendsFriendIsNotMeFilter(User user) {
        return friend -> !user.getName().equals(friend.getFriendName());
    }

    private Predicate<Friend> isNotMyFriendFilter(List<String> myFriendList) {
        return friend -> !myFriendList.contains(friend.getFriendName());
    }
}

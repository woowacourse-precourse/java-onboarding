package onboarding.problem7;

import java.util.List;
import java.util.stream.Collectors;

public class Friends {

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
        if (friends.size() > 100000) {
            throw new IllegalStateException("Friends의 크기는 10000이하어야 합니다.");
        }
    }
}

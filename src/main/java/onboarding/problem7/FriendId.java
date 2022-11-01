package onboarding.problem7;

import onboarding.problem7.exception.FriendsException;

import java.util.List;
import java.util.Objects;

public class FriendId {
    private static final int MAX = 2;
    private final List<SnsId> friend;

    public FriendId(List<SnsId> snsIds) {
        checkMAX(snsIds);
        this.friend = snsIds;
    }

    private static void checkMAX(List<SnsId> snsIds) {
        if (snsIds.size() > MAX) {
            throw new FriendsException("친구 관계 정보의 최대 크기는 2입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendId friend1 = (FriendId) o;
        return Objects.equals(friend, friend1.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friend);
    }

    public List<SnsId> getFriend() {
        return friend;
    }
}

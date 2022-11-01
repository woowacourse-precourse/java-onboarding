package onboarding.problem7;

import java.util.List;

public class Friend {
    private static final int MAX = 2;
    private final List<SnsId> friend;

    public Friend(List<SnsId> snsIds) {
        checkMAX(snsIds);
        this.friend = snsIds;
    }

    private static void checkMAX(List<SnsId> snsIds) {
        if (snsIds.size() > MAX){
            throw new FriendsException("친구 관계 정보의 최대 크기는 2입니다.");
        }
    }

    public List<SnsId> getFriend() {
        return friend;
    }
}

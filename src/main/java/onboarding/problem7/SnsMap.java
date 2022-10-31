package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class SnsMap {
    private final Map<String, List<UserId>> snsMap;

    public SnsMap() {
        this.snsMap = new HashMap<>();
    }

    public void put(UserId userId, UserId value) {
        List<UserId> before = this.get(userId);
        before.add(value);
        snsMap.put(userId.getId(), before);
    }

    public List<UserId> get(UserId userId) {
        return snsMap.getOrDefault(userId.getId(), new ArrayList<UserId>());
    }
}

package onboarding.problem7;

import java.util.List;

public class SnsNetwork {
    private final SnsMap snsMap;

    public SnsNetwork(FriendRelation friendRelation) {
        this.snsMap = new SnsMap();
        friendRelation.getFriends().forEach(this::addConnection);
    }

    private void addConnection(List<UserId> connection) {
        UserId first = connection.get(0);
        UserId second = connection.get(1);
        snsMap.put(first, second);
        snsMap.put(second, first);
    }

    public List<UserId> getConnection(UserId userId) {
        return snsMap.get(userId);
    }

    public RecommendMap getRecommend(UserId target) {
        List<UserId> directFriends = snsMap.get(target);
        RecommendMap recommendMap = new RecommendMap();
        directFriends.forEach((friend) -> {
            List<UserId> friendRelations = snsMap.get(friend);
            setRecommendMap(recommendMap, friendRelations);
        });
        return recommendMap;
    }

    private void setRecommendMap(RecommendMap recommendMap, List<UserId> friendRelations) {
        friendRelations.forEach((friend) -> recommendMap.add(friend, 10));
    }
}

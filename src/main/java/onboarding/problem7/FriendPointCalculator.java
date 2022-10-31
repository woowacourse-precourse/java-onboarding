package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendPointCalculator implements PointCalculator {

    @Override
    public Map<String, Integer> calculateWithPoint(List<String> newFriends,
        int point) {
        Map<String,Integer> result = new HashMap<>();

        newFriends.forEach(newFriend -> result.put(newFriend,result.getOrDefault(newFriend,0) + point));

        return result;
    }
}

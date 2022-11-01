package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;

public class FriendGroupRepository {
    private Map<String,FriendGroup> friendGroupMap = new HashMap<>();

    public FriendGroup getFriendGroupOfUser(String userId){
        if(!friendGroupMap.containsKey(userId)) {
            friendGroupMap.put(userId, new FriendGroup());
        }

        return friendGroupMap.get(userId);
    }
}

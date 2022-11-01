package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;

public class FriendGroup {
    private Set<String> friends = new HashSet<>();

    public boolean isFriendWith(String userId){
        return friends.contains(userId);
    }

    public void addFriendIfNotExist(String userId){
        friends.add(userId);
    }

    public int getNumberOfCommonFriends(FriendGroup otherFriends){
        Set<String> commonFriends = new HashSet<>();
        commonFriends.addAll(friends);
        commonFriends.retainAll(otherFriends.friends);

        return commonFriends.size();
    }
}

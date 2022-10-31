package onboarding.problem1.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserConnection {
    private Set<String> userGroup = new HashSet<>();
    private Map<String,Set<String>> friendsOfEachUser = new HashMap<>();

    public void connectNewFriendship(List<String> friendship){
        for(String user : friendship) {
            if (friendsOfEachUser.get(user) == null) {
                friendsOfEachUser.put(user, new HashSet<>());
                userGroup.add(user);
            }
        }

        friendsOfEachUser.get(friendship.get(0)).add(friendship.get(1));
        friendsOfEachUser.get(friendship.get(1)).add(friendship.get(0));
    }

    public boolean isFriendWith(String userA, String userB){
        return friendsOfEachUser.get(userA).contains(userB);
    }

    public Set<String> getUserGroup(){
        return userGroup;
    }

    public int getNumberOfCommonFriends(String UserA, String UserB){
        Set<String> commonFriends = new HashSet<>(friendsOfEachUser.get(UserA));
        commonFriends.retainAll(friendsOfEachUser.get(UserB));

        return commonFriends.size();
    }
}

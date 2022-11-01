package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Problem7 {

    public static HashMap<String, Integer> inputHash (List<List<String>> friends) {
        HashSet<String> overlapFriendKeys = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            overlapFriendKeys.add(friends.get(i).get(0));
            overlapFriendKeys.add(friends.get(i).get(1));
        }
        List<String> friendKeys = new ArrayList<>(overlapFriendKeys);
        Collections.sort(friendKeys);

        HashMap<String, Integer> friendsRelation = new HashMap<>(friendKeys.size());

        for (int j = 0; j < friendKeys.size(); j++) {
            friendsRelation.put(friendKeys.get(j), 0);
        }
        return friendsRelation;
    }

    public static HashMap<String, Integer> scoreVisitFriend (HashMap<String, Integer> friendsRelation, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendsRelation.containsKey(visitor)){
                friendsRelation.put(visitor, 1);
            }else {
                friendsRelation.put(visitor, friendsRelation.get(visitor)+1);
            }
        }
        return friendsRelation;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
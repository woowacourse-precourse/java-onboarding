package onboarding.problem7;

import java.util.*;

public class FriendRecommender {

    public static List<String> getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = new ArrayList<>();
        List<List<String>> anotherRelation = new ArrayList<>();
        HashMap<String, Integer> recommendList = new HashMap<>();

        for (List<String> friend : friends) {
            separateFriends(friend,user,userFriends,anotherRelation);
        }

        return new ArrayList<>();
    }

    private static void separateFriends(List<String> friendship, String user, List<String> userFriends, List<List<String>> anotherRelation) {
        if (friendship.contains(user)) {
            Integer index = getIndex(friendship,user);
            userFriends.add(friendship.get(index));
            return;
        }
        anotherRelation.add(friendship);
    }

    private static Integer getIndex(List<String> userFriendList, String separationTarget) {
        return userFriendList.indexOf(separationTarget) == 0 ? 1 : 0;
    }
}

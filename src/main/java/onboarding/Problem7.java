package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {

    private static List<String> GetFriendShipFromName(List<List<String>> friendRelations, String user) {
        List<String> friendList = new LinkedList<>();
        friendList.add(user);
        for (List<String> friendRelation : friendRelations) {
            if (friendRelation.contains(user)) {
                friendRelationAddUser(friendList, friendRelation, user);
            }
        }
        return friendList;
    }

    private static void friendRelationAddUser(List<String> friendList, List<String> friendRelation, String user) {
        for (String friendName : friendRelation) {
            if (!friendName.equals(user))
                friendList.add(friendName);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

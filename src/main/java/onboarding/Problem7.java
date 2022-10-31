package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    static HashSet<String> alreadyFriends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void checkAllRelationInfo(List<List<String>> friends, String user) {
        for (List<String> readOneList : friends) {
            String leftID = readOneList.get(0);
            String rightID = readOneList.get(1);
            isAlreadyFriend(leftID, rightID, user);
        }
    }

    public static void isAlreadyFriend(String leftID, String rightID, String user) {
        if (leftID.equals(user)) {
            alreadyFriends.add(rightID);
        }
        if (rightID.equals(user)) {
            alreadyFriends.add(leftID);
        }
    }
}
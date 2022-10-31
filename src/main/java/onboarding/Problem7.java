package onboarding;

import java.util.*;

public class Problem7 {
    static HashSet<String> alreadyFriends = new HashSet<>();
    static List<String> acquaintance = new ArrayList<>();

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

    public static void addAcquaintanceID(List<List<String>> friends, String user) {
        for (List<String> readOneList : friends) {
            String leftID = readOneList.get(0);
            String rightID = readOneList.get(1);
            checkAcquaintance(leftID, rightID, user);
        }
    }

    public static void checkAcquaintance(String leftID, String rightID, String user) {
        for (Iterator<String> alreadyFriend = alreadyFriends.iterator(); alreadyFriend.hasNext(); ) {
            isAcquaintance(leftID, rightID, user, alreadyFriend.next());
        }
    }

    public static void isAcquaintance(String leftID, String rightID, String user, String alreadyFriend) {
        if (excludeUser(leftID, rightID, user)
                && leftID.equals(alreadyFriend)) {
            acquaintance.add(rightID);
        }
        if (excludeUser(leftID, rightID, user)
                && rightID.equals(alreadyFriend)) {
            acquaintance.add(leftID);
        }
    }

    public static boolean excludeUser(String leftID, String rightID, String user) {
        if (!leftID.equals(user) && !rightID.equals(user)) {
            return true;
        }
        return false;
    }
}
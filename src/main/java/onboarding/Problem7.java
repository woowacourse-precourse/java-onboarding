package onboarding;

import java.util.*;

public class Problem7 {
    static HashMap<String, Integer> members;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        createFriendsList(user, friends, visitors);
        recommendPoint(user, friends, visitors);
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static HashMap createFriendsList(String user, List<List<String>> friends, List<String> visitors) {
        members = new HashMap<String, Integer>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                members.put(name, 0);
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            members.put(visitors.get(i), 0);
        }
        members.remove(user);
        return members;
    }

    public static void recommendPoint(String user, List<List<String>> friends, List<String> visitors) {
        for (int i = 0; i < friends.size(); i++) {
            String userFriendL = friends.get(i).get(0);
            String userFriendR = friends.get(i).get(1);

            if (userFriendL.equals(user)) {
                for (int j = 0; j < friends.size(); j++) {
                    String friendOfFriendL = friends.get(j).get(0);
                    String friendOfFriendR = friends.get(j).get(1);
                    if (friendOfFriendL.equals(userFriendR) && !friendOfFriendR.equals(user)) {
                        int oldValue = members.get(friendOfFriendR);
                        int newValue = oldValue + 10;
                        members.replace(friendOfFriendR, newValue);
                    }
                    if (friendOfFriendR.equals(userFriendR) && !friendOfFriendL.equals(user)) {
                        int oldValue = members.get(friendOfFriendR);
                        int newValue = oldValue + 10;
                        members.replace(friendOfFriendL, newValue);
                    }
                }
            }
            if (userFriendR.equals(user)) {
                for (int j = 0; j < friends.size(); j++) {
                    String friendOfFriendL = friends.get(j).get(0);
                    String friendOfFriendR = friends.get(j).get(1);
                    if (friendOfFriendL.equals(userFriendL) && !friendOfFriendR.equals(user)) {
                        int oldValue = members.get(friendOfFriendR);
                        int newValue = oldValue + 10;
                        members.replace(friendOfFriendR, newValue);
                    }
                    if (friendOfFriendR.equals(userFriendL) && !friendOfFriendL.equals(user)) {
                        int oldValue = members.get(friendOfFriendR);
                        int newValue = oldValue + 10;
                        members.replace(friendOfFriendL, newValue);
                    }
                }
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            int oldValue = members.get(visitor);
            int newValue = oldValue + 1;
            members.replace(visitor, newValue);
        }
    }
}

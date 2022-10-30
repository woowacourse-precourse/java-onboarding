package onboarding;

import java.util.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
    static List<String> userFriends = new ArrayList<>();
    static HashMap<String, Integer> allUsersID = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        createUserFriendsList(user, friends);
        registerNewUserInFriendsList(user, friends);
        registerNewUserInVisitorsList(visitors);


        return answer;
    }

    private static void createUserFriendsList (String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user_A = friend.get(0);
            String user_B = friend.get(1);
            if (user.equals(user_A)) {
                userFriends.add(user_B);
            }
            if (user.equals(user_B)) {
                userFriends.add(user_A);
            }
        }
    }

    private static void registerNewUserInFriendsList (String User, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user_A = friend.get(0);
            String user_B = friend.get(1);
            if (User.equals(user_A) || User.equals(user_B)) {
                continue;
            }
            boolean isUserAFriend = isUsersFriend(user_A);
            boolean isUserBFriend = isUsersFriend(user_B);
            if (isUserAFriend && isUserBFriend) {
                continue;
            }

            if (isUserAFriend) {
                if (allUsersID.containsKey(user_B)) {
                    allUsersID.put(user_B, allUsersID.get(user_B) + 10);
                }
                else {
                    allUsersID.put(user_B, 10);
                }
                continue;
            }

            if (isUserBFriend) {
                if (allUsersID.containsKey(user_A)) {
                    allUsersID.put(user_A, allUsersID.get(user_A) + 10);
                }
                else {
                    allUsersID.put(user_A, 10);
                }
                continue;
            }

            if (!allUsersID.containsKey(user_A)) {
                allUsersID.put(user_A, 0);
            }

            if (!allUsersID.containsKey(user_B)) {
                allUsersID.put(user_B, 0);
            }
        }
    }

    private static boolean isUsersFriend (String userID) {
        boolean isFriend = false;
        if (userFriends.contains(userID)) {
            isFriend = true;
        }
        return isFriend;
    }

    private static void registerNewUserInVisitorsList (List<String> visitors) {
        for (String visitor : visitors) {
            if (isUsersFriend(visitor)) {
                continue;
            }
            if (allUsersID.containsKey(visitor)) {
                allUsersID.put(visitor, allUsersID.get(visitor) + 1);
            }
            else {
                allUsersID.put(visitor, 1);
            }
        }
    }

    private static LinkedHashMap<String, Integer> sortAllUsersIDByKey () {
        List<HashMap.Entry<String, Integer>> entries = new LinkedList<>(allUsersID.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (HashMap.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static LinkedHashMap<String, Integer> sortAllUsersIDByValue () {
        List<HashMap.Entry<String, Integer>> entries = new LinkedList<>(allUsersID.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (HashMap.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
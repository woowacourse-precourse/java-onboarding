package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriends = getUsersFriends(user, friends);
        HashMap<String, Integer> recommendMap = getFriendssFriends(user, friends, usersFriends);
        List<String> visitorExceptFriend = getVisitorExceptFriend(visitors, usersFriends);

        return answer;
    }

    private static List<String> getVisitorExceptFriend(List<String> visitors, List<String> usersFriends) {
        List<String> newVisitorsList = new ArrayList<>();

        for (String visitor : visitors) {
            if (!usersFriends.contains(visitor)) {
                newVisitorsList.add(visitor);
            }
        }
        return newVisitorsList;
    }

    private static HashMap<String, Integer> getFriendssFriends(String user, List<List<String>> friends, List<String> usersFriends) {
        HashMap<String, Integer> recommandList = new HashMap<>();

        for (String friendName : usersFriends) {
            for (List<String> friend : friends) {
                if (friend.contains(friendName) && !friend.contains(user)) {
                    if (friend.get(0).equals(friendName)) {
                        setHashMap(recommandList, friend.get(1));
                    } else {
                        setHashMap(recommandList, friend.get(0));
                    }
                }
            }
        }
        return recommandList;
    }

    private static void setHashMap(HashMap<String, Integer> recommandList, String recommandName) {
        if (!recommandList.containsKey(recommandName)) {
            recommandList.put(recommandName, 10);
        } else {
            recommandList.put(recommandName, recommandList.get(recommandName) + 10);
        }
    }

    private static List<String> getUsersFriends(String user, List<List<String>> friends) {
        List<String> friendList = new ArrayList<>();

        for (List<String> name : friends) {
            if (name.get(0).equals(user)) {
                friendList.add(name.get(1));
            }
            if (name.get(1).equals(user)) {
                friendList.add(name.get(0));
            }
        }
        return friendList;
    }
}

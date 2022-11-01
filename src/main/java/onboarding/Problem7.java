package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.singletonList("aa");
        List<String> userFriendList = getUserList(user, friends);
        List<String> userList = getUserList(friends, visitors);
        Map<String, Integer> userObject = getUserObject(userList);
        Map<String, Integer> userSocreObject = countScore(user, userFriendList, friends, userObject,
            visitors);

        return answer;
    }


    public static Map<String, Integer> getUserObject(List<String> userList) {
        Map<String, Integer> userObject = new HashMap<>();

        for (String mapUser : userList) {
            userObject.put(mapUser, 0);
        }

        return userObject;
    }

    public static Map<String, Integer> countScore(String user, List<String> userFriendList,
        List<List<String>> friends, Map<String, Integer> userObject, List<String> visitors) {
        List<String> friendsFirendList = new ArrayList<>();

        for (String userFriend : userFriendList) {
            for (int i = 0; i < friends.size(); i++) {
                if (friends.get(i).indexOf(userFriend) == 1 && friends.get(i).get(0) != user) {
                    friendsFirendList.add(friends.get(i).get(0));
                }
                if (friends.get(i).indexOf(userFriend) == 0 && friends.get(i).get(1) != user) {
                    friendsFirendList.add(friends.get(i).get(1));
                }
            }
        }
        Map<String, Integer> userFriendScore = countFriendScore(userObject, friendsFirendList);

        return countVisitScore(userFriendScore, visitors);
    }

    private static Map<String, Integer> countVisitScore(Map<String, Integer> userFriendScore,
        List<String> visitors) {
        for (String visitor : visitors) {
            if (userFriendScore.containsKey(visitor)) {
                userFriendScore.put(visitor, userFriendScore.get(visitor) + 1);
            }
        }
        return userFriendScore;
    }

    public static Map<String, Integer> countFriendScore(Map<String, Integer> userObject,
        List<String> friendsFriendList) {
        for (String friendsFriend : friendsFriendList) {
            if (userObject.containsKey(friendsFriend)) {
                userObject.put(friendsFriend, userObject.get(friendsFriend) + 10);
            }
        }

        return userObject;
    }

    public static List<String> getUserList(String user, List<List<String>> friends) {
        List<String> userFriendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.indexOf(user) == 1) {
                userFriendList.add(friend.get(0));
            }
            if (friend.indexOf(user) == 0) {
                userFriendList.add(friend.get(1));
            }
        }

        return userFriendList;
    }

    public static List<String> getUserList(List<List<String>> friends, List<String> visitors) {
        List<String> flattenUserList = new ArrayList<>();

        for (List<String> friend : friends) {
            flattenUserList.addAll(friend);
        }
        flattenUserList.addAll(visitors);

        return flattenUserList.stream().distinct().collect(Collectors.toList());
    }
}

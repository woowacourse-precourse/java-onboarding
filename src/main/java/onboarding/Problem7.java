package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> map = friends(friends);
        List<String> userFriends = extractUserFriendsList(friends, user);
        List<String> allUser = extractAllUserList(friends);
        List<String> userNotFriends = extractUserNotFriendsList(userFriends, user, allUser);

        userInFriendsLinkedList(map, userNotFriends);
        return userFriends;
    }

    public static List<String> extractAllUserList(List<List<String>> friends) {
        List<String> allUserList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (!allUserList.contains(friends.get(i).get(0))) {
                allUserList.add(friends.get(i).get(0));
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            if (!allUserList.contains(friends.get(i).get(1))) {
                allUserList.add(friends.get(i).get(1));
            }
        }

        System.out.println("alluserList" + allUserList);
        return allUserList;
    }

    public static List<String> extractUserFriendsList(List<List<String>> friends,
                                                      String user) {
        List<String> userFriendsList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                userFriendsList.add(friends.get(i).get(0));
                userFriendsList.add(friends.get(i).get(1));
            }
        }
        removeUserFromUserFriendsList(userFriendsList, user);

        System.out.println("userFriendsList" + userFriendsList);
        return userFriendsList;
    }

    public static List<String> extractUserNotFriendsList(List<String> userFriends, String user, List<String> allUser) {
        List<String> userNotFriendsList = allUser;

        for (int i = 0; i < userFriends.size(); i++) {
            userNotFriendsList.remove(userFriends.get(i));
        }
        userNotFriendsList.remove(user);

        System.out.println("userNotFriendList" + allUser);
        return userNotFriendsList;
    }

    public static List<String> removeUserFromUserFriendsList(
            List<String> userFriendList, String user) {

        while (userFriendList.remove(user)) {
        }

        return userFriendList;
    }

    public static Map<String, List<String>> friends(List<List<String>> friends) {
        Map<String, List<String>> friendsLinkedList = new TreeMap<>();
        List<String> belongFriendsList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friendsLinkedList.containsKey(friends.get(i).get(0))) {
                belongFriendsList.add(friends.get(i).get(1));
                friendsLinkedList.put(friends.get(i).get(0), belongFriendsList);
            }
            if (!friendsLinkedList.containsKey(friends.get(i).get(0))) {
                belongFriendsList = new ArrayList<>();
                belongFriendsList.add(friends.get(i).get(1));
                friendsLinkedList.put(friends.get(i).get(0), belongFriendsList);
            }
        }

        System.out.println(friendsLinkedList);
        return friendsLinkedList;
    }

    public static Map<String, List<String>> userInFriendsLinkedList(
            Map<String, List<String>> friendsLinkedList,
            List<String> userNotFriendList) {
        for (int i = 0; i < friendsLinkedList.size(); i++) {
            friendsLinkedList.remove(userNotFriendList.get(i));
        }

        System.out.println("연결된 리스트의 값에서 user가 없는 부분 제거"+friendsLinkedList);
        return friendsLinkedList;
    }
}

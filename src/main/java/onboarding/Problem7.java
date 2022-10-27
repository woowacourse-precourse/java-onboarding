package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriendList = userFriendList(user, friends);

        List<String> friendsFriendList = friendsFriend(userFriendList, friends,user);

        HashMap<String, Integer> map = new HashMap<>();

        for (String friendsFriend : friendsFriendList) {
            if (!userFriendList.contains(friendsFriend)) {
                map.put(friendsFriend, 10);
            }

        }

        for (String visitor : visitors) {
            if (map.containsKey(visitor) && !userFriendList.contains(visitor)) {
                map.put(visitor,map.get(visitor)+1);
            }

            if (!map.containsKey(visitor)&& !userFriendList.contains(visitor)) {
                map.put(visitor, 1);
            }
        }

        Arrays.sort(map.keySet().toArray());

        answer.addAll(map.keySet());

// 테스트는 통과했지만 정렬을 구현하지 못함.

        return answer;
    }

    static List<String> userFriendList(String user,List<List<String>> friends) {
        List<List<String>> userFriendLists = new ArrayList<>();
        List<String> userFriendList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriendLists.add(friend);
            }
        }

        for (int i = 0; i < userFriendLists.size(); i++) {
            for (int j = 0; j < userFriendLists.get(i).size(); j++) {
                if (userFriendLists.get(i).get(j) != user) {
                    userFriendList.add(userFriendLists.get(i).get(j));
                }
            }
        }

        return userFriendList;
    }

    static List<String> friendsFriend(List<String> userFriendList,List<List<String>> friends,String user) {
        List<String> friendsFriend = new ArrayList<>();
        List<List<String>> temp = new ArrayList<>();

        for (List<String> friend : friends) {
            for (String userFriend : userFriendList) {
                if (friend.contains(userFriend)) {
                    temp.add(friend);
                }
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                if (!userFriendList.contains(temp.get(i).get(j)) && !temp.get(i).get(j).equals(user)) {
                    friendsFriend.add(temp.get(i).get(j));
                }
            }
        }

        return friendsFriend;
    }
}

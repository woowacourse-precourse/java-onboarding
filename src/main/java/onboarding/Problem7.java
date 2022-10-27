package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static final int firstFriend = 0;
    static final int secondFriend = 1;
    static final int knowPoint = 10;
    static final int visitPoint = 1;
    static List<List<String>> friendsList;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        friendsList = friends;
        //Collections.copy(friendsList, friends);

        giveFriendsPoint(user);

        return answer;
    }

    //특정 사람과 친구인 사람 구하기
    public static List<String> findUserFriends(String user) {
        List<String> userFriendsList = new ArrayList<>();
        String friends = "";

        for (int i = 0; i < friendsList.size(); i++) {
            if (user.equals(friendsList.get(i).get(firstFriend)))
                userFriendsList.add(friendsList.get(i).get(secondFriend));
            if (user.equals((friendsList.get(i).get(secondFriend))))
                userFriendsList.add(friendsList.get(i).get(firstFriend));
        }
        return userFriendsList;
    }

    //point 주는 함수
    public static Map<String, Integer> giveFriendsPoint(String user)
    {
        int root = 0;

        List<String> userFriendsList;
        List<String> friendOfFriendsList;
        Map<String, Integer> friendsPointMap= new HashMap<>();

        //사용자와 친구인 목록
        userFriendsList = findUserFriends(user);
        //사용자와 친구인 친구의 목록
        friendOfFriendsList = findUserFriends(userFriendsList.get(root));

        for (int i = 1; i < userFriendsList.size(); i++)
            friendOfFriendsList.addAll(findUserFriends(userFriendsList.get(i)));

        //중복을 제거해줌
        for (int i = 0; i < friendOfFriendsList.size(); i++)
        {
            //사용자가 리스트에 있을 경우
            if (user.equals(friendOfFriendsList.get(i)))
            {
                friendOfFriendsList.remove(i);
                continue;
            }
            //사용자의 친구가 리스트에 있을 경우
            for (int j = 0; j < userFriendsList.size(); j++)
            {
                if (userFriendsList.get(j).equals(friendOfFriendsList.get(i)))
                    friendOfFriendsList.remove(i);
            }

        }

        for (int i = 0; i < friendOfFriendsList.size(); i++)
        {
            int point = knowPoint;
            if (friendsPointMap.containsKey(friendOfFriendsList.get(i)))
                point += knowPoint;
            friendsPointMap.put(friendOfFriendsList.get(i), point);
        }

        return friendsPointMap;
    }
}

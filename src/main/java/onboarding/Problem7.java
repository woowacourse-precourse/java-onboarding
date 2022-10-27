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

        givePoint(user, visitors);

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


    public static void givePoint(String user, List<String> visitors)
    {
        List<String> userFriendsList;
        //사용자와 친구인 목록
        userFriendsList = findUserFriends(user);

        giveFriendsPoint(user, userFriendsList);
        giveVisitPoint(visitors, userFriendsList);

    }
    //사용자와 친구인 친구의 목록을 구해서 점수를 주는 함수
    //중복처리 함수를 따로 둘까?
    public static Map<String, Integer> giveFriendsPoint(String user, List<String> userFriendsList)
    {
        int root = 0;
        List<String> friendOfFriendsList;

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

        return saveUserPoint(friendOfFriendsList, knowPoint);
    }

    public static Map<String, Integer> saveUserPoint(List<String> userList, int point)
    {
        int tmp = point;
        Map<String, Integer> friendsPointMap= new HashMap<>();

        for (int i = 0; i < userList.size(); i++)
        {
            point = tmp;
            if (friendsPointMap.containsKey(userList.get(i)))
                point += knowPoint;
            friendsPointMap.put(userList.get(i), point);
        }

        return friendsPointMap;
    }
    //방문 수에 따라 점수를 주는 함수
    public static void giveVisitPoint(List<String> visitors, List<String> userFriendsList)
    {
        //중복을 제거해줌
        for (int i = 0; i < visitors.size(); i++)
        {
            //사용자의 친구가 리스트에 있을 경우
            for (int j = 0; j < userFriendsList.size(); j++)
            {
                if (userFriendsList.get(j).equals(visitors.get(i)))
                    visitors.remove(i);
            }
        }
        saveUserPoint(visitors, visitPoint);
    }
}

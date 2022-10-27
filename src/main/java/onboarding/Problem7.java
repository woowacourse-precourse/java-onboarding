package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
<<<<<<< HEAD
=======
    static int frendPoint = 10;
    static int visitPoint = 1;
    static int newFriends = 1;
    static int knowFriends = 0;

    static int recommendMax = 5;

>>>>>>> 49922b5d67382eb02c73dfe34ae1f84b3d908a79
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();


<<<<<<< HEAD
        return answer;
    }


=======
       answer = findRecommendFriends(findVisitedPoint(findKnowFriendsPoint(savaFriendsList(friends, user)), visitors), findFriendsList(friends));
        return answer;
    }

    public static List<String> findRecommendFriends(Map<String, Integer> friendsMap, List<String> knowFriendsList)
    {
        int cnt = 0;
        List<String> recommendFriendsList = new ArrayList<>();
        Integer [] friendsPointArray = new Integer[friendsMap.size()];

        System.out.println("최종 :  " + friendsMap);

        //map 배열로 저장
        Collection<Integer> values = friendsMap.values();
        friendsPointArray = values.toArray(new Integer[0]);

        Arrays.sort(friendsPointArray, Collections.reverseOrder());

        for (int i = 0; i < friendsPointArray.length; i++)
            System.out.println("hi "+ friendsPointArray[i]);

        for (int i = 0; i < friendsPointArray.length; i++)
        {
            if (friendsPointArray[i] == 0 || cnt == recommendMax)
                break;
            //중복 제거
            //이미 친구 제거
            if (!(knowFriendsList.get(i).equals(getKey(friendsMap, friendsPointArray[i]))))
            {
                recommendFriendsList.add(getKey(friendsMap, friendsPointArray[i]));
                cnt++;
            }
        }

        return recommendFriendsList;
    }

    // hashmap에 value 로 key 찾기
    public static <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    //이미 알고있는 친구 목록 구하기
    public static List<String> findFriendsList(List<List<String>> friends)
    {
        List<String> friendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++)
            friendList.add(friends.get(i).get(knowFriends));
        return friendList;
    }

    //유저와 알고있는 친구 목록 구하기기
   public static List<String> savaFriendsList(List<List<String>> friends, String user)
    {
        boolean userCheck = false;
        List<String> friendList = new ArrayList<>();

        //user와 알고 있어야 한다.
        for (int i = 0; i < friends.size(); i++)
        {
            //user와 알고 있으면!
            if (friends.get(i).get(newFriends).equals(user))
                userCheck = true;
            else
                friendList.add(friends.get(i).get(newFriends));
        }
        if (userCheck == false)
            return null;
        return friendList;
    }
    public static Map<String, Integer> findKnowFriendsPoint(List<String> knowFriendsList)
    {
        int point = frendPoint;
        String key;

        Map<String, Integer> knowFriendsMap = new HashMap();

        for (int i = 0; i < knowFriendsList.size(); i++)
        {
            key = knowFriendsList.get(i);
            if (knowFriendsMap.containsKey(key))
                point = knowFriendsMap.get(key) + frendPoint;
            knowFriendsMap.put(knowFriendsList.get(i), point);
            point = frendPoint;
        }

        return knowFriendsMap;
    }
    public static Map<String, Integer> findVisitedPoint(Map<String, Integer> knowFriendsMap, List<String> visitors)
    {
        int point = visitPoint;

        System.out.println("방문 : " + knowFriendsMap);
        for (int i = 0; i < visitors.size(); i++)
        {
            String key = visitors.get(i);

            if (knowFriendsMap.containsKey(key))
            {
                point = knowFriendsMap.get(key) + visitPoint;
                knowFriendsMap.put(visitors.get(i), point);
            }
            else if (!knowFriendsMap.containsKey(key))
                knowFriendsMap.put(visitors.get(i), point);
        }
        return knowFriendsMap;
    }
>>>>>>> 49922b5d67382eb02c73dfe34ae1f84b3d908a79
}

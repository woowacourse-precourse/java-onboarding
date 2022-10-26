package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static int frendPoint = 10;
    static int visitPoint = 1;
    static int newFriends = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void findRecommendFrinds(Map<String, Integer> friendsMap)
    {
        Integer [] friendsPointArray = new Integer[friendsMap.size()];

        for (int i = 0; i < friendsMap.size(); i++)
            friendsPointArray[i] = friendsMap.get(i);
        Arrays.sort(friendsPointArray, Collections.reverseOrder());


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
    
    //유저와 알고있는 친구 목록 구하기기
   public static List<String> savaFirendsList(List<List<String>> friends, String user)
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
    public static Map<String, Integer> findknowFriendsPoint(List<String> knowFriendsList)
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

        for (int i = 0; i < visitors.size(); i++)
        {
            String key = visitors.get(i);
            //null인 경우
            if (knowFriendsMap == null)
            {

            }
            if (knowFriendsMap.containsKey(key))
            {
                point = knowFriendsMap.get(key) + visitPoint;
                knowFriendsMap.put(visitors.get(i), point);
            }
        }

        return knowFriendsMap;
    }
}

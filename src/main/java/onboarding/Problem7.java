package onboarding;

import java.util.*;

public class Problem7 {
    public static Map<String, List<String>> friendsMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void initFriendsMap(List<List<String>> friends){
        friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);
            //  first에 second 추가하기
            putFriendsMap(firstFriend, secondFriend);
            putFriendsMap(secondFriend, firstFriend);

        }
    }

    public static void putFriendsMap(String key, String value){
        if(friendsMap.containsKey(key)){
            friendsMap.get(key).add(value);
        }
        else {
            List<String> values = new ArrayList<>();
            values.add(value);
            friendsMap.put(key,values);
        }
    }
}



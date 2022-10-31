package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, List<String>> friendsMap;
    public static Map<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void initScoreMap(){
        scoreMap = new HashMap<>();
    }

    public static void initFriendsMap(List<List<String>> friends){
        friendsMap = new HashMap<>();
        for (List<String> friend : friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);

            putFriendsMap(firstFriend, secondFriend);
            putFriendsMap(secondFriend, firstFriend);

        }
    }

    public static void putScoreMap(String key, int plusValue){
        if(! scoreMap.containsKey(key)){
            scoreMap.put(key, 0);
        }
        scoreMap.put(key, scoreMap.get(key) + plusValue);
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
    public static void plusAcquaintanceScore(String user){
        List<String> userFriends = friendsMap.get(user);
        for (String userFriend : userFriends) {
            List<String> acquaintanceList = getAcquaintanceList(user, userFriend);
            acquaintanceList.stream().forEach(ac -> putScoreMap(ac, 10));
        }
    }

    public static List<String> getAcquaintanceList(String user, String userFriend){
        return friendsMap.get(userFriend).stream().
                filter(acquaintance -> !acquaintance.equals(user)).collect(Collectors.toList());
    }

    public static void plusVisitorScore(List<String> visitors){
        visitors.stream().forEach(visitor -> putScoreMap(visitor, 1));
    }

}



package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, HashSet<String>> friendMap = makeFriend(friends);
        HashMap<String, Integer> scoreMap = new HashMap<>();
        recommendFriend(user, friendMap, visitors, scoreMap);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (t2.getValue() == t1.getValue()) {
                    return t1.getKey().compareTo(t2.getKey());
                } else return t2.getValue().compareTo(t1.getValue());
            }
        });

        return answer;
    }

    public static HashMap<String, HashSet<String>> makeFriend (List<List<String>> friends){
        HashMap<String, HashSet<String>> friendMap = new HashMap<>();
        for (List<String> friendRelation : friends){
            String user1 = friendRelation.get(0);
            String user2 = friendRelation.get(1);
            if (friendMap.containsKey(user1)){
                friendMap.get(user1).add(user2);
            }
            else {
                friendMap.put(user1, new HashSet<>());
                friendMap.get(user1).add(user2);
            }

            if (friendMap.containsKey(user2)){
                friendMap.get(user2).add(user1);
            }
            else {
                friendMap.put(user2, new HashSet<>());
                friendMap.get(user2).add(user1);
            }
        }
        return friendMap;
    }

    public static boolean isFriend(String user, String friend, HashMap<String, HashSet<String>> friendMap){
        if (friendMap.get(user).contains(friend) || friend.equals(user)) return true;
        else return false;
    }

    public static void recommendFriend(String user, HashMap<String, HashSet<String>> friendMap, List<String> visitors, HashMap<String, Integer> scoreMap){
        for (String friend : friendMap.get(user)){
            for (String friendOfFriend : friendMap.get(friend)){
                if (isFriend(user, friendOfFriend, friendMap)) continue;
                if (scoreMap.containsKey(friendOfFriend)) scoreMap.put(friendOfFriend, scoreMap.get(friendOfFriend) + 10);
                else scoreMap.put(friendOfFriend, 10);
            }
        }
        for (String visitor : visitors){
            if (isFriend(user, visitor, friendMap)) continue;
            if (scoreMap.containsKey(visitor)) scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            else scoreMap.put(visitor, 1);
        }
    }
}

package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    static HashMap<String,Integer> friendScoreMap;
    static List<String> userFriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendScoreMap = new HashMap<>();
        userFriends = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        findFriendsByUser(user, friends);
        scoreByFriends(user, friends);
        scoreByVisitors(user, visitors);

        List<Entry<String,Integer>> list_entries = new ArrayList<>(friendScoreMap.entrySet());
        list_entries = sortByScore(list_entries);


        return answer;
    }

    public static void findFriendsByUser(String user, List<List<String>> friends){
        for(List<String> friend : friends){
            String friendId = friend.get(1);
            if(friendId.equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
    }

    public static void scoreByFriends(String user, List<List<String>> friends){
        for(List<String> friend : friends){
            String friendId = friend.get(1);
            if(friendId.equals(user) || userFriends.contains(friendId) ) {
                continue;
            }
            friendScoreMap.put(friendId,friendScoreMap.getOrDefault(friendId,0)+10);
        }
    }

    public static void scoreByVisitors(String user, List<String> visitors){
        for(String visitor: visitors){
            if(!userFriends.contains(visitor))
                friendScoreMap.put(visitor, friendScoreMap.getOrDefault(visitor,0)+1);
        }
    }

    public static List<Entry<String,Integer>> sortByScore(List<Entry<String,Integer>> list_entries){
        Collections.sort(list_entries, (o1, o2) -> {
            if(o1.getValue()==o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });
        return list_entries;
    }
}
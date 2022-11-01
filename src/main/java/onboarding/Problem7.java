package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static HashMap<String,List<String >>getFriendMap(List<List<String>> friends){
        HashMap<String, List<String>> friendMap = new HashMap<>();
        for(List<String>friendInfo : friends){
            String friendA = friendInfo.get(0);
            String friendB = friendInfo.get(1);
            if(friendMap.containsKey(friendA)==false){
                friendMap.put(friendA,new ArrayList<>());
            }
            if(friendMap.containsKey(friendB)==false){
                friendMap.put(friendB,new ArrayList<>());
            }
        friendMap.get(friendA).add(friendB);
        friendMap.get(friendB).add(friendA);
        }
        return friendMap;
    }
    private static List<String> getFriendScore(HashMap<String,List<String >> friendMap, List<String> userFriend, String user, List<String> visitors){
        HashMap<String,Integer> friendScore = new HashMap<>();
        for(String key : friendMap.keySet()){
            friendScore.put(key,0);
        }

        for(String key : friendMap.keySet()){
            if(key==user || userFriend.contains(key)){
                continue;
            }
            List<String> friendInfo = friendMap.get(key);
            for(String friend : friendInfo){
                if(userFriend.contains(friend)){
                    friendScore.put(key,friendScore.get(key) + 10);
                }
            }
        }

        for(String visitor: visitors){
            if(friendScore.containsKey(visitor)==false){
                friendScore.put(visitor,0);
            }
            if(userFriend.contains(visitor)==false){
                friendScore.put(visitor,friendScore.get(visitor) + 1);
            }
        }
        List<String> sortedFriendScore = friendScore.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(h ->h.getValue() > 0).limit(5).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue)).keySet().stream().collect(Collectors.toCollection(ArrayList::new));

        return sortedFriendScore;
    }
    private static List<String> getResult(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String,List<String >> friendMap = getFriendMap(friends);
        List<String> userFriend = friendMap.get(user);
        List<String> friendScore = getFriendScore(friendMap,userFriend,user,visitors);
        return friendScore;

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getResult(user,friends,visitors);
        return answer;
    }
}

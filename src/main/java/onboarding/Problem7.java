package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> getTopFive(Map<String, Integer> scoreMap){
        List<String> keyList = new ArrayList<>(scoreMap.keySet());
        if(keyList.size()>5){
            keyList=keyList.subList(0,5);
        }
        return keyList;
    }
    public static Map<String, Integer> getVisitorScore( Map<String, List<String>> friendsMap,List<String> visitors,Map<String, Integer> scoreMap,String user){
        for(String visitor: visitors){
            if(!friendsMap.get(user).contains(visitor)){
                if((!scoreMap.containsKey(visitor)))
                    scoreMap.putIfAbsent(visitor, 1);
                else
                    scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            }
        }
        return scoreMap;
    }

    public static Map<String, Integer> getFriendScore( Map<String, List<String>> friendsMap,Map<String, Integer> scoreMap,String user){
        for(String friend: friendsMap.get(user)){
            for(String notfriend: friendsMap.get(friend)){
                if(notfriend!=user){
                    if((!scoreMap.containsKey(notfriend)))
                        scoreMap.putIfAbsent(notfriend, 10);
                    else
                        scoreMap.put(notfriend, scoreMap.get(notfriend) + 10);
                }
            }
        }
        return scoreMap;
    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> unSortedMap)
    {
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        return reverseSortedMap;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendsMap = new HashMap<String, List<String>>();
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        for(List<String> friend : friends) {
            String left_name = friend.get(0);
            String right_name = friend.get(1);
            friendsMap.putIfAbsent(left_name, new ArrayList<String>());
            friendsMap.get(left_name).add(right_name);
            friendsMap.putIfAbsent(right_name, new ArrayList<String>());
            friendsMap.get(right_name).add(left_name);
        }
        scoreMap=getFriendScore(friendsMap,scoreMap,user);
        scoreMap=getVisitorScore(friendsMap,visitors,scoreMap,user);

        return getTopFive(sortByValue(scoreMap));
    }
}

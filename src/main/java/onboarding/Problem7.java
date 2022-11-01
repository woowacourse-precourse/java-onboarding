package onboarding;

import org.mockito.internal.util.collections.ListUtil;

import java.util.*;
import java.util.stream.Stream;

public class Problem7 {
    static Map<String, List<String>> friendsDic(List<List<String>> friends){
        Map<String, List<String>> map = new HashMap<>();
        List<String> emptyList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(!map.containsKey(friends.get(i).get(0))){
                map.put(friends.get(i).get(0), emptyList);
            } else {
                List<String> friendsList = map.get(friends.get(i).get(0));
                friendsList.add(friends.get(i).get(1));
                map.put(friends.get(i).get(0), friendsList);
            }
            if(!map.containsKey(friends.get(i).get(1))){
                map.put(friends.get(i).get(1), emptyList);
            } else {
                List<String> friendsList = map.get(friends.get(i).get(1));
                friendsList.add(friends.get(i).get(0));
                map.put(friends.get(i).get(1), friendsList);
            }
        }
        return map;
    }
    static Map<String, Integer> peopleDic(List<List<String>> friends, List<String> visitors){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.size(); i++){
            if(!map.containsKey(friends.get(i).get(0))){
                map.put(friends.get(i).get(0), 0);
            }
            if(!map.containsKey(friends.get(i).get(1))){
                map.put(friends.get(i).get(1), 0);
            }
        }
        for(int i=0; i<visitors.size(); i++){
            if(!map.containsKey(visitors.get(i))){
                map.put(visitors.get(i), 0);
            }
        }
        return map;
    }
    static Map<String, Integer> compareFriends(String user, Map<String, List<String>> friendsMap, Map<String, Integer> pointMap){
        List<String> userFriends = new ArrayList<>();
        userFriends.addAll(friendsMap.get(user));
        for(String i : friendsMap.keySet()){
            if(i != user && !userFriends.contains(i)){
                List<String> friendsList = new ArrayList<>();
                friendsList.addAll(friendsMap.get(i));
                for(int j=0; j<userFriends.size(); j++){
                    if(userFriends.contains(friendsList.get(j))){
                        int point = pointMap.get(friendsList.get(j));
                        point += 10;
                        pointMap.put(friendsList.get(j), point);
                    }
                }
            }
        }
        return pointMap;
    }
    static Map<String, Integer> checkVisit(String user, Map<String, List<String>> friendsMap, Map<String, Integer> pointMap){

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

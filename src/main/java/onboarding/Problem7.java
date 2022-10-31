package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String,Integer> map = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friend = new ArrayList<>();
        user_friend = findFriends(user,friends);
        checkFriends(user,friends,user_friend);
        checkIsVisited(visitors,user_friend);
        return answer;
    }
    static void checkIsVisited(List<String> visitors,List<String> user_friend){
        for(String info : visitors){
            if(map.get(info) == null && !user_friend.contains(info)){map.put(info,1);}
            else if(map.get(info) != null && !user_friend.contains(info)){map.put(info,map.get(info)+1);}
        }
    }
    static void checkFriends(String host,List<List<String>> friends,List<String> user_friend){
        for(List<String> info : friends){
            if(user_friend.contains(info.get(0)) && info.get(1) != host){
                if(map.get(info.get(1)) == null){map.put(info.get(1),10);}
                else{map.put(info.get(1),map.get(info.get(1))+10);}}
            if(user_friend.contains(info.get(1))&& info.get(0) != host){
                if(map.get(info.get(0)) == null){map.put(info.get(0),10);}
                else{map.put(info.get(0),map.get(info.get(0))+10);}}
        }
    }
    static List<String> findFriends(String host,List<List<String>> friends){
        List<String> friend_info = new ArrayList<>();
        for(List<String> info : friends){
            if(info.get(0).equals(host)){friend_info.add(info.get(1));}
            if(info.get(1).equals(host)){friend_info.add(info.get(0));}
        }
        return friend_info;
    }
}
package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String,Integer> map = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friend = new ArrayList<>();
        user_friend = findFriends(user,friends);
        return answer;
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
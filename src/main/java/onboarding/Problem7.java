package onboarding;

import java.util.*;
import java.util.Map.*;

public class Problem7 {

    public Map<String,Integer> solution2(Map<String,String> friend,String user,List<List<String>> friends,List<String> visitors){
        Map<String,Integer> mutual = new HashMap<>();

        for(List<String> list:friends){
            if(list.get(0) != user && list.get(1) != user){
                if(friend.get(list.get(0)) != null){
                    mutual.put(list.get(1),mutual.getOrDefault(list.get(1),0)+10);
                }
                else if(friend.get(list.get(1)) != null){
                    mutual.put(list.get(0),mutual.getOrDefault(list.get(0),0)+10);
                }
            }
        }

        for(String str:visitors){
            if(friend.get(str) == null) mutual.put(str, mutual.getOrDefault(str,0)+1);
        }

        return mutual;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p = new Problem7();
        List<String> answer = new ArrayList<>();

        Map<String,String> friend = new HashMap<>();

        for(List<String> list:friends){
            if(list.get(0) == user) friend.put(list.get(1), list.get(0));
            if(list.get(1) == user) friend.put(list.get(0), list.get(1));
        }

        for(Entry<String,Integer> entry:p.solution2(friend,user,friends,visitors).entrySet()){
            answer.add(entry.getKey());
        }

        return answer;
    }
}

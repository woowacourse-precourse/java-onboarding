package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    public static List<String> findAcquaintance(String user,List<String> findFreinds,List<List<String>> friends){
        List<String> result=new ArrayList<>();
        for(String friend:findFreinds){
            result.addAll(findFriends(friend,friends));
            result.remove(user);
        }
        return result;
    }
    public static List<String> findFriends(String user,List<List<String>> friends){
        List<String> result=new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.contains(user)) {
                addFriend(friend.indexOf(user),result,friend);
            }
        }
        return result;
    }
    public static void addFriend(int index,List<String> result,List<String> freind){
        if(index==0)
            result.add(freind.get(1));
        if(index==1)
            result.add(freind.get(0));
    }
    public static Map<String,Integer> friendScoreCalculator(List<String> acquaintance){
        Map<String,Integer> result=new HashMap<>();
        for(String name:acquaintance){
            result.putIfAbsent(name, 10);
            if(result.get(name)!=null)
                result.put(name, result.get(name)+10);
        }
        return result;
    }

}

package onboarding;

import java.util.*;

public class Problem7 {
    private static final HashMap<String, LinkedList<String>> relation = new HashMap<>();
    private static final HashMap<String, Integer> score = new HashMap<>();
    private static final int MAX_SIZE = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        makeFriendRelation(friends);
        setAcquaintanceScore(user);
        setVisitorsScore(user, visitors);
        return answer;
    }

    public static void makeFriendRelation(List<List<String>> friends){
        for(List<String> friend : friends){
            String name1 = friend.get(0);
            String name2 = friend.get(1);
            addNameByKey(name1, name2);
            addNameByKey(name2, name1);
        }
    }

    public static void addNameByKey(String user, String friend){
        if(relation.containsKey(user)){
            relation.get(user).add(friend);
        } else{
            relation.put(user, new LinkedList<String>(Collections.singleton(friend)));
            score.put(user, 0);
        }
    }

    public static void setAcquaintanceScore(String user){
        for(String friend : relation.get(user)){
           for(String name : relation.get(friend)){
               if(!name.equals(user)) score.replace(name, score.get(name) + 10);
           }
        }
    }

    public static void setVisitorsScore(String user, List<String> visitors){
        for(String visitor : visitors){
            if(relation.get(user).contains(visitor)) continue; // 방문자가 이미 친구라면

            if(score.containsKey(visitor)){
                score.replace(visitor, score.get(visitor) + 1);
            }else{
                score.put(visitor, 1);
            }
        }
    }
}

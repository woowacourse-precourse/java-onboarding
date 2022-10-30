package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {
    private static final HashMap<String, LinkedList<String>> relation = new HashMap<>();
    private static final HashMap<String, Integer> score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        makeFriendRelation(friends);
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
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static HashMap<String,Integer> recommendPoint = new HashMap<>();
    public static void calculatePoint(String target, Integer point){
        if(!recommendPoint.containsKey(target)){ //add
            recommendPoint.put(target,0);
        }
        recommendPoint.replace(target, recommendPoint.get(target)+ point);
    }

    public static List<String> getUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();
        for(int i=0; i<friends.size(); i++){
            if(friends.get(i).contains(user)){
                String userFriend = getAnotherOne(friends.get(i),user);
                userFriends.add(userFriend);
            }
        }
        return userFriends;
    }
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

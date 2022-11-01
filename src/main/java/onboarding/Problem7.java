package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        Set<String> friendSet = new HashSet<>();
        Map<String, Integer> neighborMap = new HashMap<>();

        friendSet.add(user);
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                friendSet.add(friendList.get(0));
                friendSet.add(friendList.get(1));
            }
        }
        friendSet.remove(user);


        return answer;
    }
}

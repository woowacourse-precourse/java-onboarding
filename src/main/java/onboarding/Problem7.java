package onboarding;

import java.util.*;

public class Problem7 {
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


        System.out.println(scoreMap);
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

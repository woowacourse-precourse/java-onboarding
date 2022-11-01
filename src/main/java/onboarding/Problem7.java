package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public HashMap<String, List<String>> arrange_friends_list(List<List<String>> friends){
        HashMap<String, List<String>> friends_list =new HashMap<>();
        for(List<String> link : friends){
            String friendA = link.get(0);
            String friendB = link.get(1);

            List<String> A_friends = friends_list.getOrDefault(friendA, new ArrayList<>());
            List<String> B_friends = friends_list.getOrDefault(friendB, new ArrayList<>());

            A_friends.add(friendB);
            B_friends.add(friendA);

            friends_list.put(friendA,A_friends);
            friends_list.put(friendB,B_friends);

        }
        return friends_list;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    static void createfriendsGroups(HashMap<String,List<String>> friendsGroups, List<List<String>>friends, String userName){
        for(int i=0; i<friends.size(); i++){
            String friends1 = friends.get(i).get(0);
            String friends2 = friends.get(i).get(1);

            if(!friendsGroups.containsKey(friends1)) {
                friendsGroups.put(friends1, new ArrayList<>());
            }
            if(!friendsGroups.containsKey(friends2)) {
                friendsGroups.put(friends2, new ArrayList<>());
            }
            friendsGroups.get(friends1).add(friends2);
            friendsGroups.get(friends2).add(friends1);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String,List<String>> friendsGroups = new HashMap<>();
        createfriendsGroups(friendsGroups,friends,user);
        return answer;
    }
}

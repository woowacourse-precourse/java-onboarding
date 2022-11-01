package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Set<String> getUserFriends(String user, List<List<String>> friends){
        Set<String> userFriends = new HashSet<>();

        for (List<String> friendList : friends){
            if(friendList.contains(user)){
                for (String friend : friendList){
                    if(!friend.equals(user)){
                        userFriends.add(friend);
                    }
                }
            }
        }

        return userFriends;
    }


}

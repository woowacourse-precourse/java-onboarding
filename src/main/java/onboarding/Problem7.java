package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> friendsWithUser = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        addFriendsWithUser(user,friends);
        return answer;
    }

    public static void addFriendsWithUser(String user, List<List<String>> friends) {
        for(List<String> list : friends){
            if(list.contains(user)) {
                for (String friend : list) {
                    if(!friend.equals(user)){
                        friendsWithUser.add(friend);
                    }
                }
            }
        }
    }
}
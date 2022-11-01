package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }
    public static List<String> makeFriendList(String user, List<List<String>> freinds){
        List<String> userFriends = new ArrayList<>();
        for (List<String> item :freinds){
            if(item.get(0).equals(user)){
                userFriends.add(item.get(1));
            }
            else if(item.get(1).equals(user)){
                userFriends.add(item.get(0));
            }
        }
        return userFriends;
    }


}

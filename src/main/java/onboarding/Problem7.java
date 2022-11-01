package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    public static HashMap<String,Boolean> user_friend;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        user_friend = new HashMap<String,Boolean>();
        List<String> answer = Collections.emptyList();

        return answer;
    }

    public static void userFriendCheck(String user,List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).get(0)==user){
                user_friend.put(friends.get(i).get(1),true);
            }
            else if(friends.get(i).get(1)==user){
                user_friend.put(friends.get(i).get(0),true);
            }
            else continue;
        }
    }
}

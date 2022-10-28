package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // user의 friend 구하기
        ArrayList<String> userFriends = new ArrayList<String>();
        for(List<String> friendList : friends){
            if(friendList.contains(user)){
                // add friend
                for(String friendName: friendList){
                    if(friendName != user){
                        userFriends.add(friendName);
                    }
                }
            }
        }
        System.out.println(userFriends);

        return answer;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static ArrayList<String> findFriend(String user, List<List<String>> friends){
        ArrayList<String> userFriend = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++){
            String nameA = friends.get(i).get(0);
            String nameB = friends.get(i).get(1);

            if(nameA.equals(user)){
                userFriend.add(nameB);
            }
            if(nameB.equals(user)){
                userFriend.add(nameA);
            }
        }
        return userFriend;
    }
}

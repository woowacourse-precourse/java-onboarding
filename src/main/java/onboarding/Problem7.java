package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendsOfUser = findFriendsOfUser(user, friends);


        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriendsOfUser(String user, List<List<String>> friends){

        List<String> friendsOfUser = new ArrayList<>();

        for(int i=0; i < friends.size() ; i++){
            if(friends.get(i).contains(user)){
                int userIndex = friends.get(i).indexOf(user);
                friendsOfUser.add(friends.get(i).get(1-userIndex));
            }
        }
        return friendsOfUser;
    }
}

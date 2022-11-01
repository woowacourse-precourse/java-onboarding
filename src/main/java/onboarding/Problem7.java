package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        List<String> friendsOfUser = new ArrayList<>();

        for (int i =0 ; i < friends.size() ; i++) {
            int userIndex = friends.get(i).indexOf(user);

            int friendIndex = 1-userIndex;

            friendsOfUser.add(friends.get(i).get(friendIndex));
        }



        List<String> answer = Collections.emptyList();
        return answer;
    }
}

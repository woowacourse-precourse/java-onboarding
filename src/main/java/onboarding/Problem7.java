package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < friends.size(); i += 1) {
            if (friends.get(i).get(1) == user){
                friendList.add(friends.get(i).get(0));
            } else if (friends.get(i).get(0) == user) {
                friendList.add(friends.get(i).get(1));
            }
        }


        for (int i = 0; i < friends.size(); i += 1) {
            for (int j = 0; j < friendList.size(); j += 1){
                if (friends.get(i).get(1) == friendList.get(j)){

                } else if (friends.get(i).get(0) == friendList.get(j)) {

                }
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}

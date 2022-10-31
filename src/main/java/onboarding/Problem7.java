package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> recomList =new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        List<Integer> recomScore = new ArrayList<Integer>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String name = friends.get(i).get(j);
                if (!recomList.contains(name)) {
                    if(name == user) break;
                    recomList.add(name);
                }
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            if(!recomList.contains(name)) {
                recomList.add(name);
            }
        }

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (friends.get(i).get(j) == user) {
                    if(!userFriends.contains(friends.get(i).get((j+1)%2))) {
                        userFriends.add(friends.get(i).get((j+1)%2));
                    }
                }
            }
        }

        for (int i = 0; i < userFriends.size(); i++) {
            recomList.remove(userFriends.get(i));
        }

        for (int i = 0; i < recomList.size(); i++) {
            recomScore.add(0);
        }







        return answer;
    }
}

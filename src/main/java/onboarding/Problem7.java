package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i += 1) {
            if (friends.get(i).get(1) == user){
                friendList.add(friends.get(i).get(0));
            } else if (friends.get(i).get(0) == user) {
                friendList.add(friends.get(i).get(1));
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}

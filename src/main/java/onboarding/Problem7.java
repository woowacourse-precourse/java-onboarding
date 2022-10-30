package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = new ArrayList<>();
        for (List<String> friend : friends) {
            if(friend.contains(user))
            {
                if(friend.get(0).equals(user)) friendList.add(friend.get(1));
                else friendList.add(friend.get(0));
            }
        }



        return answer;
    }
}

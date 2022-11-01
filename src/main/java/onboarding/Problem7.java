package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static List<String> CurrentFriends(String usr, List<List<String>> friends){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).contains(usr)){
                list.add(friends.get(i).get(0));
                list.add(friends.get(i).get(1));
            }
        }
        list.remove(usr);
        return list;
    }
}

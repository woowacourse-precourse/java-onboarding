package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friend_list = createFrined_List(user, friends);
        
        return answer;
    }

    public static List<String> createFrined_List(String user, List<List<String>> friends) {
        List<String> friend_list = new ArrayList<>();

        friend_list.add(user);
        for(List<String> f : friends) {
            if(user.equals(f.get(0))) friend_list.add(f.get(1));
            if(user.equals(f.get(1))) friend_list.add(f.get(0));
        }

        return friend_list;
    }
}

package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static boolean isUser(String user, List<String> userList) {
        if(user.equals(userList.get(0)) || user.equals(userList.get(1))) {
            return true;
        }
        return false;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashSet<String> userFriends;


        return answer;
    }
}

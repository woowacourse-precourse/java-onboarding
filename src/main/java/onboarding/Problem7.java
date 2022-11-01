package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    //기능1. 사용자의 친구 목록
    public static List<String> userFriends(String user, List<List<String>> friends){
        HashSet<String> userFri = new HashSet<>();

        for (List<String> fri: friends) {

            if(fri.get(0).equals(user)){
                userFri.add(fri.get(1));
            } else if (fri.get(1).equals(user)) {
                userFri.add(fri.get(0));
            }
        }

        List<String> userFriends = new ArrayList<>(userFri);

        return userFriends;
    }
}

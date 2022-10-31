package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<String> myFriends = getUsersFriends(user, friends);


        return answer;
    }

    private static List<String> getUsersFriends(String me, List<List<String>> friends) {
        List<String> my = new ArrayList<>();

        for(List<String> connection : friends) {
            if (connection.contains(me)) {
                my.addAll(connection);
            }
        }

        while(my.contains(me)) {
            my.remove(me);
        }

        return my;
    }
}

package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<String>();
        List<List<String>> temp = friends.stream().filter(friend -> friend.contains(user)).collect(Collectors.toList());
        for(List users: temp) {
            for(int i = 0; i < 2; i++) {
                if(users.get(i) != user) {
                    userFriends.add((String) users.get(i));
                }
            }
        }
        return userFriends;
    }


}

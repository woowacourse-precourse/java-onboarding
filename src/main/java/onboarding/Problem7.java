package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static Set<String> findUserFriend(String user, List<List<String>> friends) {
        Set<String> friend = new HashSet<>();
        //friend.add(user);
        for(int i=0;i<friends.size();i++){
            String leftPerson = friends.get(i).get(0);
            String rightPerson = friends.get(i).get(1);
            if(leftPerson.equals(user))friend.add(rightPerson);
            if(rightPerson.equals(user))friend.add(leftPerson);
        }
        return friend;
    }
}

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // user의 친구 리스트
        List<String> userFriendsList = new ArrayList<>();
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).get(0).equals(user)) {
                userFriendsList.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                userFriendsList.add(friends.get(i).get(0));
            }
        }

        return answer;
    }
}

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        List<String> userFriends = new ArrayList<>();
        Map<String, Integer> userScore = new TreeMap<String, Integer>();

        // user와 친구인 사람들 userFriends에 넣어준다.
        for(List<String> friend : friends) {
            int idx = friend.indexOf(user);
            if(idx != -1) {
                userFriends.add(friend.get((idx + 1) % 2));
            }
        }

        return answer;
    }
}

package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    static HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

    static void addScore(String name, int score) {
        if(scoreMap.get(name)==null) {
            scoreMap.put(name, score);
        } else {
            scoreMap.put(name, scoreMap.get(name)+score);
        }
    }
    public static Set<String> getFriendsOfUser(String user, List<List<String>> friends) {
        Set<String> setFriendsOfUser = new HashSet<String>();
        for(int i=0; i<=friends.size()-1; i++) {
            if(friends.get(i).get(0).equals(user)) {
                setFriendsOfUser.add(friends.get(i).get(1));
            } else if(friends.get(i).get(1).equals(user)) {
                setFriendsOfUser.add(friends.get(i).get(0));
            }
        }
        return setFriendsOfUser;
    }
}

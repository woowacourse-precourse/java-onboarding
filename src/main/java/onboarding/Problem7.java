package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static HashMap<String,Integer> scoreList = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            if(user == friends.get(i).get(0)) userFriends.add(friends.get(i).get(1));
            else if(user == friends.get(i).get(1)) userFriends.add(friends.get(i).get(0));
        }

        return answer;
    }

}

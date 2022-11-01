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
        for(int i=0;i<friends.size();i++){
            String firstFriend = friends.get(i).get(0);
            String secondFriend = friends.get(i).get(1);
            if(user == firstFriend || user == secondFriend) continue;
            if(userFriends.contains(firstFriend) && !userFriends.contains(secondFriend)) {
                addFriendScore(secondFriend, 10);
            }
            else if(userFriends.contains(secondFriend) && !userFriends.contains(firstFriend)) {
                addFriendScore(firstFriend, 10);
            }
        }

        return answer;
    }
    public static void addFriendScore(String name, int score) {
        if(scoreList.containsKey(name))
            score += scoreList.get(name);
        scoreList.put(name, score);
    }
}

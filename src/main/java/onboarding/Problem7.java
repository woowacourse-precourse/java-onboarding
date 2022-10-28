package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static HashMap<String, List<String>> friendRelation;
    public static HashMap<String, Integer> Score;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static void makeFriendRelation (List<String> friend){
        addFriendRelation(friend.get(0), friend.get(1));
        addFriendRelation(friend.get(1), friend.get(0));
    }
    public static void addFriendRelation (String friend1, String friend2){
        List<String> newFriend= new ArrayList<>();
        if(friendRelation.containsKey(friend1)){
            newFriend = friendRelation.get(friend1);
        }
        newFriend.add(friend2);
        friendRelation.put(friend1,newFriend);
    }

}

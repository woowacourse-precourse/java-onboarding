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
    public static void plusScoreByFriend(String user){
        List<String> userFriends = friendRelation.get(user);
        for(int i=0;i< userFriends.size();i++){
            plusFriendScore(userFriends.get(i));
        }
    }
    public static void plusFriendScore(String userFriend){
        List<String> userFriendOfFriends = friendRelation.get(userFriend);
        for(int i=0;i<userFriendOfFriends.size();i++) {
            plusScore(userFriendOfFriends.get(i), 10);
        }
    }
    public static void plusScoreByVisitor(List<String> visitors){
        for(int i=0;i<visitors.size();i++){
            plusVisitorScore(visitors.get(i));
        }
    }
    public static void plusVisitorScore(String visitor){
        plusScore(visitor, 1);
    }
    public static void plusScore(String name, int score){
        int newScore = score;
        if(Score.containsKey(name)){
            newScore += Score.get(name);
        }
        Score.put(name, newScore);
    }
    private static void sortingByScore(List<String> recommendList) {
        recommendList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareScore(o1, o2);
            }
        });
    }
    private static int compareScore(String o1, String o2){
        if(Score.get(o1)<Score.get(o2)){
            return 1;
        }
        if(Score.get(o1)>Score.get(o2)){
            return -1;
        }
        return o1.compareTo(o2);
    }
}

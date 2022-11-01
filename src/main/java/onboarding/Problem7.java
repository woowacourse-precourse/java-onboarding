package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class User{
    final int FRIEND_A=0;
    final int FRIEND_B=1;
    final int ACQUAINTANCE_SCORE=10;
    final int VISIT_SCORE=1;
    String user;
    int totalScore;
    List<String> relationship = new ArrayList<>();
    User(String userName){
        user=userName;
        totalScore=0;
    }
    boolean isMyFriend(List<String> relation){
        return relation.contains(user);
    }
    int findLocation(List<String> relation){
        int index=relation.indexOf(user);
        if(index==FRIEND_A){
            return FRIEND_B;
        }
        else{
            return FRIEND_A;
        }
    }
    void findFriends(List<List<String>> relations){
        List<String> myFriends = new ArrayList<>();
        int friendIndex;
        for(List<String> relation: relations){
            if(isMyFriend(relation)){
                friendIndex=findLocation(relation);
                myFriends.add(relation.get(friendIndex));
            }
        }
        relationship=myFriends;
    }
    String getName(){
        return user;
    }
    void updateVisitScore(){
        totalScore+=VISIT_SCORE;
    }
    void updateAcquaintanceScore(){
        totalScore+=ACQUAINTANCE_SCORE;
    }
    int getTotalScore(){
        return totalScore;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

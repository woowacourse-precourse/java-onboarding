package onboarding;

import java.util.*;

class User implements Comparable<User>{
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
    List<String> getRelationship(){
        return relationship;
    }
    @Override
    public int compareTo(User u) {
        if(totalScore != u.totalScore){
            return Integer.compare(u.totalScore,totalScore);
        }
        return user.compareTo(u.user);
    }
}
class RelationShip {
    List<String> uniqueFriends = new ArrayList<>();
    HashMap<String, User> users= new HashMap<>();

    void getUniqueFriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            uniqueFriends.addAll(friend);
        }
        HashSet<String> uniqueFriend = new HashSet<>(uniqueFriends);
        uniqueFriends = new ArrayList<>(uniqueFriend);
    }
    HashMap<String, User> makeRelation(List<List<String>> friends){
        for (String s : uniqueFriends) {
            User userSNS = new User(s);
            userSNS.findFriends(friends);
            users.put(s, userSNS);
        }
        return users;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

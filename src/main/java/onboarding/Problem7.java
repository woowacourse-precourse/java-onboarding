package onboarding;

import java.util.Collections;
import java.util.List;
class User{
    final int FRIEND_A=0;
    final int FRIEND_B=1;
    String user;
    int totalScore;
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
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

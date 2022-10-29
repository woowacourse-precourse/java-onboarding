package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findFriends(String user,List<List<String>> friends){
        List<String> result=new ArrayList<>();
        for(List<String> friend:friends){
            if(friend.contains(user)) {
                addFriend(friend.indexOf(user),result,friend);
            }
        }
        return result;
    }
    public static void addFriend(int index,List<String> result,List<String> freind){
        if(index==0)
            result.add(freind.get(1));
        if(index==1)
            result.add(freind.get(0));
    }
}
